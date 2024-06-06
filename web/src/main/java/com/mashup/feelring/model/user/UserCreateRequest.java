package com.mashup.feelring.model.user;

import lombok.Data;

@Data
public class UserCreateRequest {
    private final String email;
    private final String password;

    private final String nickname;

    private final String providerName;
    private final String providerId;
}
