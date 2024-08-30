package org.company.workorders.infrastructure.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception {

        //allow any OPTIONS requests to any api route
        // all other requests must be authenticated
        http.authorizeHttpRequests(authorizeRequest -> authorizeRequest.requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated()).oauth2ResourceServer(it -> it.jwt(Customizer.withDefaults()));


        return http.build();
    }

}
