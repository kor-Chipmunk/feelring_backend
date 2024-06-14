package com.mashup.feelring.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder
@RequiredArgsConstructor
public class OAuthUser {

    private final String userId;
    private final String email;
    private final String profileImage;

    public static OAuthUser of(
            String userId,
            String email,
            String profileImage
    ) {
        return OAuthUser.builder()
                .userId(userId)
                .email(email)
                .profileImage(profileImage)
                .build();
    }
}
