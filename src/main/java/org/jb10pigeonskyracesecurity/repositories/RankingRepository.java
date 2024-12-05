package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Ranking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends MongoRepository<Ranking, String> {
    @Query("{ 'race.$id' : ?0 }")
    List<Ranking> findByRaceId(String raceId);
}
