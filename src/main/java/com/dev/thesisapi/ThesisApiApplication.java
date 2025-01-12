package com.dev.thesisapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ThesisApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisApiApplication.class, args);
    }

}
