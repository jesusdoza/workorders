package org.company;

import org.company.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
    UserRepository repository;
    @Autowired
    private MockMvc mvc;

    @Test
    void givenUnauthenticatedUser_userInfoEndpointReturnsUnauthorized() throws Exception {
        mvc.perform(get("/api/user/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void givenAuthenticatedUser_userInfoEndpointReturnsOk() throws Exception {
        mvc.perform(get("/api/user/me")
                        .with(jwt()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("Subject").value("user"))
                .andExpect(jsonPath("claims").isMap())
                .andDo(print());
    }


}

