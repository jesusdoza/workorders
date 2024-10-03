package org.company.user;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserProfileRepository repository;

    public UserService(UserProfileRepository repository) {
        this.repository = repository;
    }


    public Optional<User> findUserByAuthServerId(AuthServerId authServerId) {
        return repository.findByAuthServerId(authServerId);

    }

    public User createUser(CreateUserParameters createUserParameters) {

        User user = new User(createUserParameters.authServerId(), createUserParameters.username(), createUserParameters.email(), Set.of(UserRole.USER), createUserParameters.mobileToken());

        //todo should handle unique only auth_server_id, mobile token also user_id also needs to be unique
        return repository.save(user);

    }
}
