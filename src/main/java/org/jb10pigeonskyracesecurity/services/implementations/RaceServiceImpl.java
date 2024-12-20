package org.jb10pigeonskyracesecurity.services.implementations;


import org.jb10pigeonskyracesecurity.events.RaceClosedEvent;

import org.jb10pigeonskyracesecurity.dtos.RaceDTO;
import org.jb10pigeonskyracesecurity.exception.ResourceNotFoundException;
import org.jb10pigeonskyracesecurity.models.Breeder;

import org.jb10pigeonskyracesecurity.models.Race;
import org.jb10pigeonskyracesecurity.repositories.RaceRepository;
import org.jb10pigeonskyracesecurity.services.RaceService;
import org.jb10pigeonskyracesecurity.utils.GeoUtil;
import org.jb10pigeonskyracesecurity.utils.mappers.dtos.BreederMapper;
import org.jb10pigeonskyracesecurity.utils.mappers.dtos.RaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final RaceMapper raceMapper;
    private final GeoUtil geoUtil;
    private final ApplicationEventPublisher eventPublisher;
    private BreederMapper breederMapper;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, RaceMapper raceMapper, GeoUtil geoUtil, ApplicationEventPublisher eventPublisher) {
        this.raceRepository = raceRepository;
        this.raceMapper = raceMapper;
        this.geoUtil = geoUtil;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public RaceDTO save(RaceDTO raceDTO) {
        Race race = raceMapper.toRace(raceDTO);
        Race savedRace = raceRepository.save(race);
        return findById(String.valueOf(savedRace.getId()));
    }

    @Override
    public RaceDTO update(String id, RaceDTO raceDTO) {
        Race race = findEntityById(id);
        raceMapper.updateRaceFromDto(raceDTO, race);
        race = raceRepository.save(race);
        return raceMapper.toDTO(race);
    }

    @Override
    public List<RaceDTO> saveAll(List<RaceDTO> raceDTOs) {
        return raceDTOs.stream()
                .map(this::save)
                .toList();
    }

    @Override
    public List<RaceDTO> findAll() {
        return raceRepository.findAll().stream()
                .map(raceMapper::toDTO)
                .toList();
    }

    @Override
    public RaceDTO close(String id) {
        double avgDistance = calculateAvgDistance(id);
        RaceDTO raceDTO = RaceDTO.builder().closedAt(LocalDateTime.now()).avgDistance(avgDistance).build();
        eventPublisher.publishEvent(new RaceClosedEvent(this, raceDTO));
        return update(id, raceDTO);
    }

    public Race findEntityById(String id) {
        Optional<Race> race = raceRepository.findById(id);
        if(race.isPresent()){
            return race.get();
        } else {
            throw new ResourceNotFoundException("Race not found");
        }
    }

    @Override
    public RaceDTO findById(String id) {
        return raceMapper.toDTO(findEntityById(id));
    }

    @Override
    public double calculateAvgDistance(String id) {
        List<Breeder> breeders = getParticipatingBreeders(id);
        RaceDTO raceDTO = findById(id);
        return breeders.stream().mapToDouble(loft -> geoUtil.haversine(raceDTO.startCoordinates(), loft.getLoftCoordinates())).average().orElse(0.0);
    }


    @Override
    public List<Breeder> getParticipatingBreeders(String id) {
        return raceRepository.findDistinctLoftsByRaceId(id);

    }
}
