package com.sap.ideationportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IdeationportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeationportalApplication.class, args);
	}

}
