package com.itasofttest.concertsystem;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher registerMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.POST.toString()) && request.getServletPath().equals("/auth/register");
            }
            
        };
    
        RequestMatcher loginMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.POST.toString()) && request.getServletPath().equals("/auth/login");
            }
        };

        RequestMatcher getAllMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.GET.toString()) && request.getServletPath().equals("/ticket/getAll");
            }
        };

        RequestMatcher createMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.POST.toString()) && request.getServletPath().equals("/ticket/create");
            }
        };

        RequestMatcher updateMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.PUT.toString()) && request.getServletPath().startsWith("/ticket/update/");
            }
        };

        RequestMatcher deleteMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return request.getMethod().equals(HttpMethod.DELETE.toString()) && request.getServletPath().startsWith("/ticket/delete/");
            }
        };


    
        http
            .csrf(csrf -> csrf.disable())
            .authorizeRequests(authorizeRequests -> authorizeRequests
                .requestMatchers(loginMatcher, registerMatcher, deleteMatcher, updateMatcher, createMatcher, getAllMatcher).permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
    
        return http.build();
    }

    
}

