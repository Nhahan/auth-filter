package org.example.authfilter.controller;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.dto.UserResponse;
import org.example.authfilter.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/users")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
}
