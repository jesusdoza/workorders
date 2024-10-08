package org.company.user.web;

import org.company.user.AuthServerId;
import org.company.user.User;

import java.util.UUID;

public class UserDto {
    private UUID userId;
    private String username;
    private String email;
    private String mobileToken;
    private String authServerId;

    public UserDto(UUID userId, String username, String email, String mobileToken, String authServerId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.mobileToken = mobileToken;
        this.authServerId = authServerId;

    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getUserId(), user.getUsername(), user.getEmail(), user.getMobileToken(), user.getAuthServerId());
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

    public String getMobileToken() {
        return mobileToken;
    }

    public void setMobileToken(String mobileToken) {
        this.mobileToken = mobileToken;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getAuthServerId() {
        return authServerId;
    }

    public void setAuthServerId(String authServerId) {
        this.authServerId = authServerId;
    }
}
