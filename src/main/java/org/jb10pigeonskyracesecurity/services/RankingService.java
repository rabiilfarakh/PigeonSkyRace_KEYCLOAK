package org.jb10pigeonskyracesecurity.services;

import org.jb10pigeonskyracesecurity.dtos.RankingCSVDTO;
import org.jb10pigeonskyracesecurity.dtos.RankingDTO;
import org.jb10pigeonskyracesecurity.models.Ranking;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RankingService {
    public RankingDTO addPigeonToRace(RankingDTO rankingDTO);
    public List<RankingDTO> saveAll(RankingCSVDTO rankingCSVDTO);
    List<RankingDTO> calculateAndRank(String raceId);
    List<Ranking>  convertCSV(MultipartFile file);
}
