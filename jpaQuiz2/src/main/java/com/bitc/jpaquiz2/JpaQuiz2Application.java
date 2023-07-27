package com.bitc.jpaquiz2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaQuiz2Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaQuiz2Application.class, args);
    }

}
