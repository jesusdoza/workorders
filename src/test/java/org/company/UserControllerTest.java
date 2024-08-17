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
//    @Test
//    //test with test token
//    void givenAuthenticatedUser_userInfoEndpointReturnsOk() throws Exception {
//        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLdzNkd3g5bElJWTdlLU90cXJBWU5EUjJIV081WVRZX0NPY3hCZFFldmhFIn0.eyJleHAiOjE3MjM5MjQ3ODcsImlhdCI6MTcyMzkyNDQ4NywiYXV0aF90aW1lIjoxNzIzOTI0NDg0LCJqdGkiOiIwNjdmMTAxYi1kNDUzLTRjNTgtYWVmMy0zMzhjYmRiNDFkMTgiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgxODAvcmVhbG1zL3dvcmtvcmRlcnMiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNzlmZjk3MjMtYTIyZC00NTY0LThjNDktN2YxNzk1MDhlMmJlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoid29ya29yZGVycy1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiODVlMDU3NWItMTM0NS00ZDRiLTllNmYtNDRhYTI4MTYzOTg3IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwczovL29hdXRoLnBzdG1uLmlvIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXdvcmtvcmRlcnMiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiODVlMDU3NWItMTM0NS00ZDRiLTllNmYtNDRhYTI4MTYzOTg3IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoid2ltIGV4YW1wbGUiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ3aW1AZXhhbXBsZS5jb20iLCJnaXZlbl9uYW1lIjoid2ltIiwiZmFtaWx5X25hbWUiOiJleGFtcGxlIiwiZW1haWwiOiJ3aW1AZXhhbXBsZS5jb20ifQ.mCyv_Nths-j_BGRq6v17DjR-rTZn_K-oYI5MgdhlA7NLpyKaliqniVPDfWYrU1DJPY2Lo0oLpwoyXlMtGEg8PwKPDRbItNVButQcRAbCZNcsJ_TFFfRH9DjVRqEg2eHpaXxbn7lTFsPNs9LaW7G2Mp_8ujawUkmNUfkj9fv6tHFU2s8KdlpxjvNvNpq-VI6xY0YKAhgXJSxaqV1mEVLZy6bRG1VCa7rOe9h9WQkAuPgKmKGJbSPLlVP2FBZhGfb1kaVg6q04dxCOVTPl1sDMBvh--r7sCL3sdADdkMTNH25I-JmX6ppfDUl1w7CgL-jqw2dBaR0cQH7h3aCDaR6lBg";
//
//
//        mvc.perform(get("/api/user/me")
//                        .header("Authorization", "Bearer " + token))
//                .andExpect(status().isOk());
////                .andExpect(jsonPath("subject").value("user"))
////                .andExpect(jsonPath("claims").isMap())
////                .andDo(print());
//    }


}

