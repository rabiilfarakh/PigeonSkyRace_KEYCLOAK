package org.jb10pigeonskyracesecurity.services;

import org.jb10pigeonskyracesecurity.dtos.CompetitionDTO;

import java.util.List;

public interface CompetitionService {
    CompetitionDTO save(CompetitionDTO competitionDTO);
    CompetitionDTO update(String id, CompetitionDTO competitionDTO);
    CompetitionDTO close(String id);
    List<CompetitionDTO> saveAll(List<CompetitionDTO> competitionDTOs);
    List<CompetitionDTO> findAll();
    CompetitionDTO findById(String id);
}
