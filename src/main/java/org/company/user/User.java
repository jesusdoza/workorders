package org.company.user;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "user_profile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private UUID userId = UUID.randomUUID();

    //    @Column(name = "auth_provider")
//    private String authProvider; // incase of using multi auth providers
    @Column(name = "auth_server_id")
//    private AuthServerId authServerId;// when using oauth this id is used to identify record
    private String authServerId;// when using oauth this id is used to identify record


    private String name;
    private String email;
    private String username;

    @Column(name = "mobile_token")
    private String mobileToken; //used to send data to user app

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles = Set.of(UserRole.USER);

    @Column(name = "organization_id")
    private Long organizationId;


    //oauth user with specified uuid
    public User(String authServerId, String username, String email, Set<UserRole> roles, String mobileToken) {

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

    public String getAuthServerId() {
        return authServerId;
    }

    public void setAuthServerId(String authServerId) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", authServerId='" + authServerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", mobileToken='" + mobileToken + '\'' +
                ", roles=" + roles +
                ", organizationId=" + organizationId +
                '}';
    }
}
