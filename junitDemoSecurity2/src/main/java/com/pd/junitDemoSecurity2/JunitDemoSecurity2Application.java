package com.pd.junitDemoSecurity2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
@EnableCaching
public class JunitDemoSecurity2Application {

	public static void main(String[] args) {
		SpringApplication.run(JunitDemoSecurity2Application.class, args);
	}

}
