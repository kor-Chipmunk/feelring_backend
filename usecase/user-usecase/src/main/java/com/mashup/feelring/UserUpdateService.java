package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUpdateService implements UserUpdateUsecase {

    private final UserPort userPort;

    @Override
    public User update(Request request) {
        return null;
    }
}
