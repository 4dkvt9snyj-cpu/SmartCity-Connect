package com.smartcity.grievance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    public class SecurityConfig {

        @Bean
        public InMemoryUserDetailsManager userDetailsService() {

            String adminId = "admin";
            String password = "CityAdmin@2026";
            String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";

            if (!adminId.matches(regex)) {
                throw new IllegalStateException("Invalid Admin ID");
            }

            return new InMemoryUserDetailsManager(
                    User.withUsername(adminId)
                            .password("{noop}" + password)
                            .roles("ADMIN")
                            .build()
            );
        }



        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.ignoringRequestMatchers(
                            "/grievances",
                            "/grievances/**"
                    ))
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/admin", "/update-status")
                            .hasRole("ADMIN")
                            .anyRequest().permitAll()
                    )
                    .formLogin(form -> form
                            .defaultSuccessUrl("/admin", true)
                            .permitAll()
                    );

            return http.build();
        }

    }
