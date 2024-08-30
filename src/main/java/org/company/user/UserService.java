package org.company.user;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public Optional<User> findUserByAuthServerId(AuthServerId authServerId) {
        return repository.findByAuthServerId(authServerId);

    }

    public User createUser(CreateUserParameters createUserParameters) {

        User user = new User(createUserParameters.authServerId(), createUserParameters.username(), createUserParameters.email(), Set.of(UserRole.USER), createUserParameters.mobileToken());

        return repository.save(user);

    }
}
