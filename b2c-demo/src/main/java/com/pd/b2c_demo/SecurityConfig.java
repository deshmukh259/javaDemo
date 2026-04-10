package com.pd.b2c_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf(cs-> cs.disable())
        .authorizeHttpRequests(auth->
                auth.requestMatchers("/","/time","/login", "/login/oauth2/code/**","/login/oauth2/code/azure").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)
                        .failureHandler((request, response, exception) -> {
                            // ✅ Print EXACT reason
                            System.out.println("=== OAuth2 FAILED ===");
                            System.out.println("Cause: " + exception.getCause());
                            System.out.println("Message: " + exception.getMessage());
                            exception.printStackTrace();
                            response.sendRedirect("/login?error=true");
                        })
                ).exceptionHandling(ex -> ex
                .authenticationEntryPoint(
                        new LoginUrlAuthenticationEntryPoint("/oauth2/authorization/azure")
                )
        );
                //.formLogin(Customizer.withDefaults());
        return http.build();
    }
}
