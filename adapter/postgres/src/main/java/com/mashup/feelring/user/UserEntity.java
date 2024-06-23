package com.mashup.feelring.user;

import com.mashup.feelring.user.model.ProviderType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    private String role;

    private String nickname;
    private String image;

    @Enumerated(EnumType.STRING)
    private ProviderType providerName;
    private String providerId;

    private LocalDateTime lastLoginAt;
    private LocalDateTime lastLogoutAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
