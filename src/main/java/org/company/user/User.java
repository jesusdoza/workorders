package org.company.user;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID userId = UUID.randomUUID();
    private AuthServerId authServerId;// when using oauth this id is used to identify record
    private String email;
    private String username;
    private String mobileToken; //used to send data to user app
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles = Set.of(UserRole.USER);


    //oauth user with specified uuid
    public User(AuthServerId authServerId, String username, String email, Set<UserRole> roles, String mobileToken) {

        this.email = email;
        this.username = username;
        this.authServerId = authServerId;
        this.mobileToken = mobileToken;
        this.roles = roles;
    }


    protected User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public @NotNull Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(@NotNull Set<UserRole> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", authServerId=" + authServerId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", mobileToken='" + mobileToken + '\'' +
                ", roles=" + roles +
                '}';
    }
}
