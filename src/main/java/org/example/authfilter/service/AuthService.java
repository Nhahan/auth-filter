package org.example.authfilter.service;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.config.JwtUtil;
import org.example.authfilter.dto.SigninRequest;
import org.example.authfilter.dto.SignupRequest;
import org.example.authfilter.dto.SigninResponse;
import org.example.authfilter.dto.SignupResponse;
import org.example.authfilter.entity.User;
import org.example.authfilter.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponse signupV1(SignupRequest signupRequest) {
        User newUser = new User(signupRequest.getEmail());
        User saveduser = userRepository.save(newUser);

        String bearerToken = jwtUtil.createToken(saveduser.getId(), saveduser.getEmail());

        return new SignupResponse(bearerToken);
    }

    @Transactional
    public String signupV2(SignupRequest signupRequest) {
        User newUser = new User(signupRequest.getEmail());
        User saveduser = userRepository.save(newUser);

        return jwtUtil.createToken(saveduser.getId(), saveduser.getEmail());
    }

    @Transactional(readOnly = true)
    public SigninResponse signinV1(SigninRequest signinRequest) {
        User user = userRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String bearerToken = jwtUtil.createToken(user.getId(), user.getEmail());

        return new SigninResponse(bearerToken);
    }

    @Transactional(readOnly = true)
    public String signinV2(SigninRequest signinRequest) {
        User user = userRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return jwtUtil.createToken(user.getId(), user.getEmail());
    }
}
