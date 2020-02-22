package com.bondarenko.int20h2020.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://int20h-app.herokuapp.com",
                        "http://int20h-app.herokuapp.com",
                        "http://localhost:8080")
                .maxAge(3600);
    }

    @Bean
    Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }
}