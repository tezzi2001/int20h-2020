package com.bondarenko.int20h2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Int20h2020Application {

    public static void main(String[] args) {
        String username = System.getenv("USERNAME");
        if ("bohdan".equals(username)) {
            SpringApplication.run(Int20h2020Application.class, args).getEnvironment().setActiveProfiles("dev");
        } else {
            SpringApplication.run(Int20h2020Application.class, args).getEnvironment().setActiveProfiles("prod");
        }
    }
}
