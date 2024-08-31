package org.example.authfilter.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.authfilter.annotation.Auth;
import org.example.authfilter.dto.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public void test(@Auth AuthUser authUser) {
        log.info("authUser | id: {}, email: {}", authUser.getId(), authUser.getEmail());
    }
}
