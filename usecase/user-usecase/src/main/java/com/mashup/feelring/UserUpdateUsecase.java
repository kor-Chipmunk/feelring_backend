package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import lombok.Data;

public interface UserUpdateUsecase {
    User update(Request request);

    @Data
    class Request {
        private final Long userId;
        private final String nickname;
        private final String image;
    }
}
