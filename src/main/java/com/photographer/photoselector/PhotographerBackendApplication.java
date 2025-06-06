package com.photographer.photoselector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication

@EnableJpaRepositories(basePackages = "com.photographer.photoselector.repository")
@EntityScan(basePackages = "com.photographer.photoselector.entity")
public class PhotographerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographerBackendApplication.class, args);
		 String secret = Encoders.BASE64.encode(Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded());
	        System.out.println("Generated JWT Secret:");
	        System.out.println(secret);
	}

}
