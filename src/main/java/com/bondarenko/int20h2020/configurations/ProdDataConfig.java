package com.bondarenko.int20h2020.configurations;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;

@Configuration
@ComponentScan("com.bondarenko.int20h2020")
@EnableJpaRepositories("com.bondarenko.int20h2020.repositories")
@Profile("prod")
public class ProdDataConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String DCN;

    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        databaseUrl += "?useUnicode=true&amp;characterEncoding=UTF-8";
        URI dbUri = new URI(databaseUrl);
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(DCN);
        return dataSource;
    }
}
