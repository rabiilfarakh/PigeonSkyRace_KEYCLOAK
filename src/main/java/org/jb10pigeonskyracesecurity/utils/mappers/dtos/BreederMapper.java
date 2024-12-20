package org.jb10pigeonskyracesecurity.utils.mappers.dtos;

import org.jb10pigeonskyracesecurity.dtos.BreederDTO;
import org.jb10pigeonskyracesecurity.models.Breeder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BreederMapper {
    BreederMapper INSTANCE = Mappers.getMapper(BreederMapper.class);

    // ResponseDTO
    @Mapping(target = "password", ignore = true)
    BreederDTO toDTO(Breeder breeder);

    // RequestDTO
    @Mapping(target = "id", ignore = true)
    Breeder toBreeder(BreederDTO breederDTO);
}
