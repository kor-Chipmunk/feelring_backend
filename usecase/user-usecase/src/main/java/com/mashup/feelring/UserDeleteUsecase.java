package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import lombok.Data;

public interface UserDeleteUsecase {
    User delete(Request request);

    @Data
    class Request {
        private final Long id;
    }
}
