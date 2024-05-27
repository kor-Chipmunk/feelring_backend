package com.mashup.feelring.model.user;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserDto {
    private final Long id;
    private final String email;
    private final String nickname;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime deletedAt;
}
