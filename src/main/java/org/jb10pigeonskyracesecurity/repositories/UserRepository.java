package org.jb10pigeonskyracesecurity.repositories;

import org.jb10pigeonskyracesecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}