package org.jb10pigeonskyracesecurity.models;

import jakarta.persistence.*;
import lombok.Data;
import org.jb10pigeonskyracesecurity.utils.enums.Role;
import org.springframework.context.annotation.Configuration;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

}