package org.company.user;


import org.company.user.web.CreateUserRequest;
import org.company.user.web.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public Map<String, Object> myself(@AuthenticationPrincipal Jwt jwt) {

//        Optional<User> userByAuthServerId = userService.findUserByAuthServerId(new AuthServerId(UUID.fromString(jwt.getSubject())));
//
//        userByAuthServerId.ifPresent(user -> result.put("userId", user.getId().toString()));
        Map<String, Object> result = new HashMap<>();


        result.put("subject", jwt.getSubject());
        result.put("claims", jwt.getClaims());

        return result;
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
