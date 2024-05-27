package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import lombok.Data;

public interface UserCreateUsecase {
    User create(Request request);

    @Data
    class Request {
        private final Long userId;
        private final String title;
    }
}
