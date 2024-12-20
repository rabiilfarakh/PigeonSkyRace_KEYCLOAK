package org.jb10pigeonskyracesecurity.dtos;

import lombok.Builder;
import org.jb10pigeonskyracesecurity.utils.records.Coordinates;

import java.util.List;

@Builder
public record BreederDTO(String id,
                         String username,
                         String password,
                         String loftName,
                         Coordinates loftCoordinates,
                         double finalScore,
                         List<PigeonDTO> pigeons) {
}
