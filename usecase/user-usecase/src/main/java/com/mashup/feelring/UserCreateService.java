package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCreateService implements UserCreateUsecase {

    private final UserPort userPort;

    @Override
    public User create(Request request) {
        return null;
    }
}
