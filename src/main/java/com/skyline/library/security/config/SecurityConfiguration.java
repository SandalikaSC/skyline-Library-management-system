package com.skyline.library.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        //configure security
              http
                 .csrf()
                .disable()
                .authorizeHttpRequests()
                 .requestMatchers("")
                 .permitAll()
                 .anyRequest()
                 .authenticated()
                      .and()
                      .sessionManagement()
                      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                      .and()
                      .authenticationProvider(authenticationProvider )
                      .addFilterBefore(jwt)
                      .
        return  http.build();
    }
}