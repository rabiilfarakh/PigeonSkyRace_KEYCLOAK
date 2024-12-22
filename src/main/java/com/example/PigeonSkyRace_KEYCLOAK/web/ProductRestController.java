package com.example.PigeonSkyRace_KEYCLOAK.web;

import com.example.PigeonSkyRace_KEYCLOAK.entities.Product;
import com.example.PigeonSkyRace_KEYCLOAK.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductRestController {
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        System.out.println("Fetching all products...");
        return productRepository.findAll();
    }


    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
}
