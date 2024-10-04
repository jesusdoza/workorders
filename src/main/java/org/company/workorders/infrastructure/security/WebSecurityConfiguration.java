package org.company.workorders.infrastructure.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {

//ALLOW ALL FOR TESTING
//        http.authorizeHttpRequests(authorizeRequest ->
//                authorizeRequest.anyRequest().permitAll()).csrf(csrf ->
//                csrf.disable());

        //allow any OPTIONS requests to any api route
        // all other requests must be authenticated
        //AUTHENTICATE ALL API ENDPOINTS
        http.authorizeHttpRequests(authorizeRequest ->
                        authorizeRequest.requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                                .requestMatchers("/api/**").authenticated()
                                .anyRequest().authenticated()).oauth2ResourceServer(it -> it.jwt(Customizer.withDefaults()))
                .csrf(AbstractHttpConfigurer::disable);


        return http.build();
    }

//    @Bean
//    public JwtDecoder jwtDecoder() {
//        System.out.println("decoder");
//        String jwkSetUri = "https://www.googleapis.com/oauth2/v3/certs"; // Google's JWK URI
//        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
//    }
}
