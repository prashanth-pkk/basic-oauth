package com.pk.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/", "/login", "/login/oauth2/code/*").permitAll() // Allow public access to home and login URLs
                .anyRequest().authenticated() // Authenticate other endpoints
                .and()
                .oauth2Login() // Enable OAuth2 login
                .loginPage("/login")
                .defaultSuccessUrl("/home", true);

        return http.build();
    }
}


