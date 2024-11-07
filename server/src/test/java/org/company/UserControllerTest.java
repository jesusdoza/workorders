package org.company;

import org.company.user.User;
import org.company.user.UserProfileRepository;
import org.company.user.UserRole;
import org.company.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = WorkOrdersApp.class)
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    UserProfileRepository repository;
    @Autowired
    private MockMvc mvc;


    @Test
    void givenUnauthenticatedUser_userInfoEndpointReturnsUnauthorized() throws Exception {
        mvc.perform(get("/api/user/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void givenAuthenticatedUser_userInfoEndpointReturnsOk() throws Exception {
        User testUser = new User("authserverId1", "bob", "bob@bob.com", Collections.singleton(UserRole.USER), "mobile token");
        UUID testUserUUID = testUser.getUserId();
        repository.save(testUser);

        //todo add valid user UUID to jwt for look up
        mvc.perform(get("/api/user/me")
                        .with(jwt().jwt(jwt -> jwt.claim("sub", "authserverId1"))))
                .andExpect(status().isOk());

        mvc.perform(get("/api/user/me")
                        .with(jwt().jwt(jwt -> jwt.claim("sub", "FAILING_SUB"))))
                .andExpect(status().isUnauthorized());

    }


}

