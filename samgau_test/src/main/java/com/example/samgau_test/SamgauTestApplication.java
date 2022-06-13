package com.example.samgau_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.samgau_test.repository")
public class SamgauTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamgauTestApplication.class, args);
	}

}
