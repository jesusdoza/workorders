package org.company.user.web;

import org.company.user.User;

import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;
    private String email;


    public UserDto(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;

    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getAuthServerId().value(), user.getUsername(), user.getEmail());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
