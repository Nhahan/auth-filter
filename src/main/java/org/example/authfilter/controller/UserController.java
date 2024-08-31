package org.example.authfilter.controller;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
