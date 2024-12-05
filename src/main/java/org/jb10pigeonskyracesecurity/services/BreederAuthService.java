package org.jb10pigeonskyracesecurity.services;

import org.jb10pigeonskyracesecurity.models.Breeder;

public interface BreederAuthService {
    String register(Breeder breeder);
    boolean login(String username, String password);
//    List<BreederDTO> findAll();
}
