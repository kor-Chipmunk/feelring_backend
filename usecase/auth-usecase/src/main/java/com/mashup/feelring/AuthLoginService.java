package com.mashup.feelring;

import com.mashup.feelring.exception.BusinessException;
import com.mashup.feelring.exception.ErrorCode;
import com.mashup.feelring.user.model.User;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthLoginService implements AuthLoginUsecase {

    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(Request request) {
        User user = userPort.findByEmail(request.getEmail());
        validatePassword(user, request.getPassword());
        return user;
    }

    private void validatePassword(User user, String rawPassword) {
        boolean matches = passwordEncoder.matches(
                rawPassword,
                user.getAccount().getPassword()
        );

        if (!matches) {
            throw BusinessException.from(ErrorCode.LOGIN_FAILED);
        }
    }
}
