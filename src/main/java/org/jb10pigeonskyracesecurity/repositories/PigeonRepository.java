package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Pigeon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PigeonRepository extends MongoRepository<Pigeon, String> {
}
