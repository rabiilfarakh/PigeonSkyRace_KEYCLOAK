package org.jb10pigeonskyracesecurity.services;

import org.jb10pigeonskyracesecurity.models.User;

public interface UserService {
    User findByUsername(String username);
    User register(User user);
}
