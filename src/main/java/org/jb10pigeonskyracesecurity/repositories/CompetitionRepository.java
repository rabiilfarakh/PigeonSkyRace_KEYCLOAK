package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
