package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import lombok.Data;

public interface AuthLoginUsecase {
    User login(Request request);

    @Data
    class Request {
        private final String email;
        private final String password;
    }
}
