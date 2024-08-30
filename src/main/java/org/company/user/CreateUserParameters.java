package org.company.user;

public record CreateUserParameters(AuthServerId authServerId, String email, String username, String mobileToken) {


}
