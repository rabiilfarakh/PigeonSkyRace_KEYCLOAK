package org.jb10pigeonskyracesecurity.utils.mappers.dtos;

import org.jb10pigeonskyracesecurity.dtos.RaceDTO;
import org.jb10pigeonskyracesecurity.models.Race;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RaceMapper {
    RaceMapper INSTANCE = Mappers.getMapper(RaceMapper.class);

    RaceDTO toDTO(Race race);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Race toRace(RaceDTO raceDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRaceFromDto(RaceDTO dto, @MappingTarget Race entity);
}
