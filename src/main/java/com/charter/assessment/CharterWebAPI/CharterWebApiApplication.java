package com.charter.assessment.CharterWebAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.charter.assessment.CharterWebAPI.repository.*")
public class CharterWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharterWebApiApplication.class, args);
	}

}
