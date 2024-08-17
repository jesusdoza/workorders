package org.company;

import org.company.technician.Technician;
import org.company.user.User;
import org.company.user.UserRepository;
import org.company.user.UserRole;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = WorkOrdersApp.class)

public class UserStoreTest {

    @Autowired
    private UserRepository repository;

    @Test
    void addUser() {

//        UUID uuid = UUID.randomUUID();
        HashSet<UserRole> roles = new HashSet<>();

        roles.add(UserRole.USER);


        List<User> items = List.of(
                new User(UUID.randomUUID(), "bob1@bob.com", "password", roles),
                new User(UUID.randomUUID(), "bob2@bob.com", "password", roles),
                new User(UUID.randomUUID(), "bob3@bob.com", "password", roles)
        );
        repository.saveAll(items);

        List<User> users = repository.findAll();

        assertThat(users, Matchers.hasSize(items.size()));


    }
}
