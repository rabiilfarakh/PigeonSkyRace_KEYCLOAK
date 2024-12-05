package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}