package org.company.user;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
    @Id
    private UUID id;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    @NotNull
    private Set<UserRole> roles;


    public User(UUID id, String email, String password, Set<UserRole> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    protected User() {

    }
}
