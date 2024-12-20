package org.jb10pigeonskyracesecurity.services.implementations;

import lombok.RequiredArgsConstructor;
import org.jb10pigeonskyracesecurity.models.User;
import org.jb10pigeonskyracesecurity.repositories.UserRepository;
import org.jb10pigeonskyracesecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}