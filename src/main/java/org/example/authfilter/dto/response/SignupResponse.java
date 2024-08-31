package org.example.authfilter.dto.response;

import lombok.Getter;

@Getter
public class SignupResponse {

    private final String bearerToken;

    public SignupResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
