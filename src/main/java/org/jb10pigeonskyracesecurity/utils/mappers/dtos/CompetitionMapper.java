package org.jb10pigeonskyracesecurity.utils.mappers.dtos;

import org.jb10pigeonskyracesecurity.dtos.CompetitionDTO;
import org.jb10pigeonskyracesecurity.models.Competition;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionMapper INSTANCE = Mappers.getMapper(CompetitionMapper.class);

    CompetitionDTO toDTO(Competition competition);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    Competition toCompetition(CompetitionDTO competitionDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompetitionFromDto(CompetitionDTO dto, @MappingTarget Competition entity);
}
