package com.bitc.securityquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SecurityQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityQuizApplication.class, args);
	}

}
