package com.mashup.feelring.model.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
