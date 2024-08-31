package org.example.authfilter.dto;

import lombok.Getter;

@Getter
public class UserResponse {

    private final String email;

    public UserResponse(String email) {
        this.email = email;
    }
}
