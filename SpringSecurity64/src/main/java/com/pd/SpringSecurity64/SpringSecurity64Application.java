package com.pd.SpringSecurity64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecurity64Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity64Application.class, args);
    }

}
