package com.mashup.feelring;

import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserReadService implements UserReadUsecase {

    private final UserPort userPort;

    @Override
    public User read(Long id) {
        return userPort.findById(id);
    }

    @Override
    public User read(String email) {
        return userPort.findByEmail(email);
    }
}
