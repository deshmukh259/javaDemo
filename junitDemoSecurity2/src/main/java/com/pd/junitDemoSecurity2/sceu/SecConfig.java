package com.pd.junitDemoSecurity2.sceu;

import com.pd.junitDemoSecurity2.AuthenticationSuccessHandelr1;
import com.pd.junitDemoSecurity2.filter.ProhabitFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecConfig {

    private final UserDetailsService userDetailsService;

    public SecConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security
                .csrf(AbstractHttpConfigurer::disable) //how do i get to know which class disable it required ?
                .authorizeHttpRequests(reg -> {
                    reg.requestMatchers("/home", "/register/**").permitAll();
                    reg.requestMatchers("/admin/**").hasRole("ADMIN");
                    reg.requestMatchers("/user/**").hasRole("USER");
                    reg.anyRequest().authenticated();
                })
                .formLogin(httpSec -> {
                    httpSec.loginPage("/login")
                            .loginProcessingUrl("/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .permitAll()
                            .successHandler(new AuthenticationSuccessHandelr1())
                            .permitAll();

                })
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(new ProhabitFilter(), AuthenticationFilter.class)

                .addFilterBefore(new RobotAuthFilter(), AuthenticationFilter.class)
                .build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    //@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
