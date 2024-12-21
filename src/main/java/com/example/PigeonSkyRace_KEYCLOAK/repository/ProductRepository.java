package com.example.PigeonSkyRace_KEYCLOAK.repository;

import com.example.PigeonSkyRace_KEYCLOAK.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
