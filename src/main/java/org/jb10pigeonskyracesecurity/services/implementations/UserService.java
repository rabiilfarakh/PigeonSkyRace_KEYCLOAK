package org.jb10pigeonskyracesecurity.services.implementations;

import org.jb10pigeonskyracesecurity.models.User;
import org.jb10pigeonskyracesecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

}