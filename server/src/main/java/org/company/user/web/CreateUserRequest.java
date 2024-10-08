package org.company.user.web;

import org.company.user.AuthServerId;
import org.company.user.CreateUserParameters;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

public record CreateUserRequest(String mobileToken) {
    public CreateUserParameters toParameters(Jwt jwt) {
        String authServerId = jwt.getSubject();


        String email = jwt.getClaimAsString("email");
        String username = jwt.getClaimAsString("preferred_username");


        return new CreateUserParameters(authServerId, email, username, mobileToken);
    }
}
