package org.example.authfilter.service;

import lombok.RequiredArgsConstructor;
import org.example.authfilter.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
