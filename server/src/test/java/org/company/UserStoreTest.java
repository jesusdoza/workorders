package org.company;

import org.company.user.AuthServerId;
import org.company.user.User;
import org.company.user.UserProfileRepository;
import org.company.user.UserRole;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = WorkOrdersApp.class)

public class UserStoreTest {

    @Autowired
    private UserProfileRepository repository;

    @Test
    void addUser() {

        HashSet<UserRole> roles = new HashSet<>();

        roles.add(UserRole.USER);


        List<User> items = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            User user = new User(UUID.randomUUID().toString(), "bob1@bob.com", "password", roles, UUID.randomUUID().toString());
            items.add(user);

        }

        repository.saveAll(items);

        List<User> users = repository.findAll();

        assertThat(users, Matchers.hasSize(items.size()));


    }
}
