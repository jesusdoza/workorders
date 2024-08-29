package org.company.user;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private AuthServerId authServerId;// when using oauth this id is used to identify record
    private String email;
    private String mobileToken; //used to send data to user app
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;


    public User(UUID id, AuthServerId authServerId, String email, String password, Set<UserRole> roles, String mobileToken) {
        this.id = id;
        this.email = email;
        this.authServerId = authServerId;
        this.mobileToken = mobileToken;
        this.password = password;
        this.roles = roles;
    }

    public User(UUID id, String email, String password, Set<UserRole> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    protected User() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AuthServerId getAuthServerId() {
        return authServerId;
    }

    public void setAuthServerId(AuthServerId authServerId) {
        this.authServerId = authServerId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @NotNull Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(@NotNull Set<UserRole> roles) {
        this.roles = roles;
    }
}
