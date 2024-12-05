package org.jb10pigeonskyracesecurity.utils.mappers.dtos;

import org.jb10pigeonskyracesecurity.dtos.PigeonDTO;
import org.jb10pigeonskyracesecurity.models.Pigeon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PigeonMapper {
    PigeonMapper INSTANCE = Mappers.getMapper(PigeonMapper.class);

    // ResponseDTO
    PigeonDTO toDTO(Pigeon pigeon);

    // RequestDTO
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "bandNumber", ignore = true),
    })
    Pigeon toPigeon(PigeonDTO pigeonDTO);
}
