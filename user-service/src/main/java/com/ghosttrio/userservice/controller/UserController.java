package com.ghosttrio.userservice.controller;

import com.ghosttrio.userservice.dto.UserDto;
import com.ghosttrio.userservice.service.UserService;
import com.ghosttrio.userservice.vo.RequestUser;
import com.ghosttrio.userservice.vo.Greeting;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    Environment environment;
    Greeting greeting;

    private UserService userService;

    @Autowired
    public UserController(Environment environment, Greeting greeting, UserService userService) {
        this.environment = environment;
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "it's working";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return environment.getProperty("test.message");
    }

    @GetMapping("/greeting")
    public String greeting() {
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);
        return "created";
    }

}
