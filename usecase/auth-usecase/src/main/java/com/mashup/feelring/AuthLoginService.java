package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthLoginService implements AuthLoginUsecase {

    private final UserPort userPort;

    @Override
    public User login(Request request) {
        return null;
    }
}
