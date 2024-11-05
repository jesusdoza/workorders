package org.company.user;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

import jakarta.servlet.http.HttpServletRequest;
import org.company.user.web.CreateUserRequest;
import org.company.user.web.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> myself(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> result = new HashMap<>();
        Optional<User> userByAuthServerId = userService.findUserByAuthServerId(jwt.getSubject());

        userByAuthServerId.ifPresent(user -> result.put("userId", user.getId().toString()));

        if (userByAuthServerId.isEmpty()) {
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.UNAUTHORIZED);
        }

        result.put("subject", jwt.getSubject());
        result.put("claims", jwt.getClaims());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@AuthenticationPrincipal Jwt jwt, @RequestBody CreateUserRequest request) {
        CreateUserParameters parameters = request.toParameters(jwt);


        User user = userService.createUser(parameters);

        //create a DTO from user instance
        return UserDto.fromUser(user);
    }
}
