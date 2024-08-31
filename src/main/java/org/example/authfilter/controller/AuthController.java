package org.example.authfilter.controller;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.dto.request.SigninRequest;
import org.example.authfilter.dto.request.SignupRequest;
import org.example.authfilter.dto.response.SigninResponse;
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

    /**
     * 사용자 가입을 처리하고 Bearer 토큰을 포함한 응답을 반환
     *
     * @param signupRequest 사용자 가입 정보를 담은 요청 본문
     * @return Bearer 토큰이 포함된 {@link SignupResponse} 객체
     */
    @PostMapping("/v1/auth/signup")
    public ResponseEntity<SignupResponse> signupV1(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.signupV1(signupRequest));
    }

    /**
     * 사용자 로그인을 처리하고 Bearer 토큰을 포함한 응답을 반환
     *
     * @param signinRequest 사용자 로그인 정보를 담은 요청 본문
     * @return Bearer 토큰이 포함된 {@link SigninResponse} 객체
     */
    @PostMapping("/v1/auth/signin")
    public ResponseEntity<SigninResponse> signinV1(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(authService.signinV1(signinRequest));
    }


    /**
     * 사용자 가입을 처리하고 Bearer 토큰을 Authorization 헤더에 포함하여 반환
     *
     * @param signupRequest 사용자 가입 정보를 담은 요청 본문
     * @return Authorization 헤더에 Bearer 토큰이 포함
     */
    @PostMapping("/v2/auth/signup")
    public ResponseEntity<Void> signupV2(@RequestBody SignupRequest signupRequest) {
        String bearerToken = authService.signupV2(signupRequest);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, bearerToken)
                .build();
    }

    /**
     * 사용자 로그인을 처리하고 Bearer 토큰을 Authorization 헤더에 포함하여 반환
     *
     * @param signinRequest 사용자 로그인 정보를 담은 요청 본문
     * @return Authorization 헤더에 Bearer 토큰이 포함된 {@link ResponseEntity}, 응답 본문 없음
     */
    @PostMapping("/v2/auth/signin")
    public ResponseEntity<Void> signinV2(@RequestBody SigninRequest signinRequest) {
        String bearerToken = authService.signinV2(signinRequest);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, bearerToken)
                .build();
    }
}
