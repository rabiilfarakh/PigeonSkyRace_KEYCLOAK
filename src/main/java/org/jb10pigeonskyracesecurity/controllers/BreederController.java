package org.jb10pigeonskyracesecurity.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.jb10pigeonskyracesecurity.exception.ResourceNotFoundException;
import org.jb10pigeonskyracesecurity.models.Breeder;
import org.jb10pigeonskyracesecurity.models.LoginRequest;
import org.jb10pigeonskyracesecurity.repositories.BreederRepository;
import org.jb10pigeonskyracesecurity.services.BreederAuthService;
import org.jb10pigeonskyracesecurity.utils.ApiResponse;
import org.jb10pigeonskyracesecurity.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/breeders")
public class BreederController {

    @Autowired
    private BreederAuthService breederAuthService;

    @Autowired
    private BreederRepository breederRepository;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Breeder>> register(@RequestBody Breeder breeder, HttpServletRequest request) {
        request.getSession().setAttribute("breederId", breeder.getId());
        breederAuthService.register(breeder);
        return ResponseEntity.ok(ResponseUtil.success(breeder, "Breeder registered successfully", request.getRequestURI()));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Breeder>> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        if (breederAuthService.login(username, password)) {
            Breeder breeder = breederRepository.findByUsername(username);
            request.getSession().setAttribute("breederId", breeder.getId());
            return ResponseEntity.ok(ResponseUtil.success(breeder, "Breeder logged in successfully", request.getRequestURI()));
        } else {
            throw new ResourceNotFoundException("Breeder Username or password not valid" );
        }
    }

}
