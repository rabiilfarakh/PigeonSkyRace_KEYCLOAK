package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Breeder;
import org.jb10pigeonskyracesecurity.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceRepository extends JpaRepository<Race, String> {

    @Query("""
        SELECT DISTINCT b
        FROM Race r
        JOIN r.rankings ra
        JOIN ra.pigeon p
        JOIN p.breeder b
        WHERE r.id = :raceId
    """)
    List<Breeder> findDistinctLoftsByRaceId(@Param("raceId") String raceId);

}
