package com.example.PigeonSkyRace_KEYCLOAK;

import com.example.PigeonSkyRace_KEYCLOAK.entities.Product;
import com.example.PigeonSkyRace_KEYCLOAK.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class PigeonSkyRaceKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigeonSkyRaceKeycloakApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Camputer")
					.price(32000.0)
					.quantity(12)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Camputer2")
					.price(1000.0)
					.quantity(2)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Camputer3")
					.price(19000.0)
					.quantity(5)
					.build());
		};
	}

}
