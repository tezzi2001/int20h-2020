package com.bondarenko.int20h2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Int20h2020Application {

    public static void main(String[] args) {
        String dbUrl = System.getenv("DATABASE_URL");
        if (dbUrl == null) {
            System.err.println("Env var 'DATABASE_URL' is not defined!\n" +
                    "Its value should be equals to 'dev' on develop server");
            System.exit(0);
        }
        if ("DEV".equals(dbUrl)) {
            SpringApplication.run(Int20h2020Application.class, args).getEnvironment().setActiveProfiles("dev");
        } else {
            SpringApplication.run(Int20h2020Application.class, args).getEnvironment().setActiveProfiles("prod");
        }
    }
}
