package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.Breeder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BreederRepository extends MongoRepository<Breeder, String> {
     Breeder findByUsername(String username);
}
