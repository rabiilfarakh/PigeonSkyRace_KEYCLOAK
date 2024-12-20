package org.jb10pigeonskyracesecurity.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.jb10pigeonskyracesecurity.dtos.RankingCSVDTO;
import org.jb10pigeonskyracesecurity.dtos.RankingDTO;
import org.jb10pigeonskyracesecurity.services.RankingService;
import org.jb10pigeonskyracesecurity.utils.ApiResponse;
import org.jb10pigeonskyracesecurity.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {
    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }
    @PostMapping("addPigeonToRace")
    public ResponseEntity<ApiResponse<RankingDTO>> addPigeonToRace(@RequestBody RankingDTO rankingDTO, HttpServletRequest requestUrl) {


        RankingDTO rankingCreated = rankingService.addPigeonToRace(rankingDTO);
        return ResponseEntity.ok(ResponseUtil.success(rankingCreated, "Pigeon added succefully to race !!", requestUrl.getRequestURI()));
    }
    @PostMapping(value = "save-all/{raceId}", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<List<RankingDTO>>> saveAll(@RequestParam("file") MultipartFile file, @PathVariable String raceId, HttpServletRequest request) throws FileNotFoundException {
//        File file = ResourceUtils.getFile("classpath:csvData/ranking.csv");
        RankingCSVDTO rankingCSVDTO = RankingCSVDTO.builder().csv(file).raceId(raceId).build();
//        List<RankingDTO> rankingList = rankingService.saveAll(file);
//        rankingDTOs = rankingDTOs.stream().toList();
        return ResponseEntity.ok(ResponseUtil.success(rankingService.saveAll(rankingCSVDTO), "Rankings saved successfully", request.getRequestURI()));
    }
}
