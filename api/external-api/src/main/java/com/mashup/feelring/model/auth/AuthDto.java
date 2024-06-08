package com.mashup.feelring.model.auth;

import com.mashup.feelring.model.user.UserDto;
import com.mashup.feelring.user.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AuthDto {
    private final UserDto user;
    private final String accessToken;
    private final String refreshToken;

    public static AuthDto from(
            User user,
            String accessToken,
            String refreshToken
    ) {
        return new AuthDto(
                UserDto.from(user),
                accessToken,
                refreshToken
        );
    }
}
