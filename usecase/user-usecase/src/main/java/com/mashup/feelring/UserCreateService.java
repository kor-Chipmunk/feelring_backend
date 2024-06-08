package com.mashup.feelring;

import com.mashup.feelring.user.model.Account;
import com.mashup.feelring.user.model.Profile;
import com.mashup.feelring.user.model.Provider;
import com.mashup.feelring.user.model.ProviderType;
import com.mashup.feelring.user.model.Role;
import com.mashup.feelring.user.model.User;
import com.mashup.feelring.user.model.UserId;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCreateService implements UserCreateUsecase {

    private final UserPort userPort;

    @Override
    public User create(Request request) {
        User user = User.signUp(
                new Account(request.getEmail(), request.getPassword()),
                Role.USER,
                new Profile(request.getNickname(), request.getImage()),
                new Provider(
                        ProviderType.valueOf(request.getProviderType()),
                        request.getProviderId()
                ),
                () -> new UserId(0L)
        );
        return userPort.save(user);
    }
}
