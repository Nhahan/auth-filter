package org.example.authfilter.controller;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.dto.request.SignupRequest;
import org.example.authfilter.dto.response.SignupResponse;
import org.example.authfilter.service.AuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/v1/auth/signup")
    public ResponseEntity<SignupResponse> signupV1(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signupV1(signupRequest));
    }

    @PostMapping("/v2/auth/signup")
    public ResponseEntity<Void> signupV2(@RequestBody SignupRequest signupRequest) {
        String bearerToken = authService.signupV2(signupRequest);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, bearerToken)
                .build();
    }
}
