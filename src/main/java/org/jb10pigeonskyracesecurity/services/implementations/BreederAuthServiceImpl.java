package org.jb10pigeonskyracesecurity.services.implementations;

import org.jb10pigeonskyracesecurity.models.Breeder;
import org.jb10pigeonskyracesecurity.repositories.BreederRepository;
import org.jb10pigeonskyracesecurity.services.BreederAuthService;
import org.jb10pigeonskyracesecurity.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreederAuthServiceImpl implements BreederAuthService {
    @Autowired
    private BreederRepository breederRepository;


    @Override
    public String register(Breeder breeder) {
        breeder.setPassword(PasswordUtil.hashPassword(breeder.getPassword()));
        breederRepository.save(breeder);
        return "Breeder registered successfully";
    }

    @Override
    public boolean login(String username, String password) {
        Breeder breeder = breederRepository.findByUsername(username);
        if (breeder != null) {
            return PasswordUtil.verifyPassword(password, breeder.getPassword());
        }
        return false;
    }

//    @Override
//    public List<BreederDTO> findAll() {
//        return breederRepository.findAll().stream()
//                .map(raceMapper::toDTO)
//                .toList();
//    }

}
