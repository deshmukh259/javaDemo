package com.pd.SpringSecurity64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authorization.method.PrePostTemplateDefaults;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecurity64Application {


    @Bean
    public PrePostTemplateDefaults prePostTemplateDefaults(){
        return new PrePostTemplateDefaults();
    }

    @Bean
    UserDetailsService userDetailsService(){

        UserDetails abc = User.withDefaultPasswordEncoder()
                .username("Abc")
                .password("password")
                .roles("USER")
                .build();

        UserDetails jo = User.withDefaultPasswordEncoder()
                .username("jo")
                .password("password")
                .roles("USER")

                .build();

        UserDetails accountant = User.withDefaultPasswordEncoder()
                .username("accountant")
                .password("password")
                .roles("ACCOUNTANT")
                .build();

        return new InMemoryUserDetailsManager(abc,jo,accountant);


    }



    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity64Application.class, args);
    }

}
