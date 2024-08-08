package com.example.books_liberary.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails mo = User.builder()
                .username("mo")
                .password("{noop}maids")
                .roles("admin")
                .build();

        UserDetails maids = User.builder()
                .username("maids")
                .password("{noop}maids")
                .roles("admin")
                .build();

return new InMemoryUserDetailsManager(mo,maids);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/books").hasRole("admin")
                        .requestMatchers(HttpMethod.GET,"/api/books/**").hasRole("admin")
                        .requestMatchers(HttpMethod.POST,"/api/books").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT,"/api/books").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/books/**").hasRole("admin")

                        .requestMatchers(HttpMethod.GET,"/api/patrons").hasRole("admin")
                        .requestMatchers(HttpMethod.GET,"/api/patrons/**").hasRole("admin")
                        .requestMatchers(HttpMethod.POST,"/api/patrons").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT,"/api/patrons").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE,"/api/patrons/**").hasRole("admin")

                        .requestMatchers(HttpMethod.POST,"/api/borrow").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT,"/api/return").hasRole("admin")
        );


        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf-> csrf.disable());

        return http.build();
    }

}
