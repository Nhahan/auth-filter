package org.example.authfilter.service;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.dto.UserResponse;
import org.example.authfilter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getEmail()))
                .toList();
    }
}
