package com.lec.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RBoardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RBoardServerApplication.class, args);
    }

}
