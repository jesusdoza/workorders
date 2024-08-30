package org.company.user;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

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


        User user = new User(createUserParameters.authServerId(), createUserParameters.email(), createUserParameters.username(), Set.of(UserRole.USER));

        return repository.save(user);

    }
}
