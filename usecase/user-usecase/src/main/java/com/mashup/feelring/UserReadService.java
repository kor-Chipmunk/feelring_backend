package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserReadService implements UserReadUsecase {

    private final UserPort userPort;

    @Override
    public User read(Long id) {
        return null;
    }
}
