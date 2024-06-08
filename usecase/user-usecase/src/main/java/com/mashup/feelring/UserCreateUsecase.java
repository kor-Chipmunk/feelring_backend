package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import lombok.Data;

public interface UserCreateUsecase {
    User create(Request request);

    @Data
    class Request {
        private final String email;
        private final String password;
        private final String nickname;
        private final String image;
        private final String providerType;
        private final String providerId;
    }
}
