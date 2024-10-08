package org.company;

import org.company.user.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest(classes = WorkOrdersApp.class)
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    UserProfileRepository repository;
    @Autowired
    private MockMvc mvc;

//    @Test
//    void givenUnauthenticatedUser_userInfoEndpointReturnsUnauthorized() throws Exception {
//        mvc.perform(get("/api/user/me"))
//                .andExpect(status().isUnauthorized());
//    }

//    @Test
//    void givenAuthenticatedUser_userInfoEndpointReturnsOk() throws Exception {
//
//        //todo add valid user UUID to jwt for look up
//        mvc.perform(get("/api/user/me")
//                        .with(jwt().jwt(jwt -> jwt.claim("user", UUID.randomUUID()))))
//                .andExpect(status().isOk());
//
//    }


}

