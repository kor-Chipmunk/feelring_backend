package com.mashup.feelring.user.model;

import com.mashup.feelring.user.model.exception.UserValidationException;
import com.mashup.feelring.user.model.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class User {

    @NonNull private UserId id;
    @NonNull private Account account;
    @NonNull private Role role;
    @NonNull private Profile profile;
    @NonNull private Provider provider;

    private LocalDateTime lastLoginAt;
    private LocalDateTime lastLogoutAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public static User signUp(
            Account account,
            Role role,
            Profile profile,
            Provider provider,
            UserRepository repository
    ) {
        return new User(
                repository.nextId(),
                account,
                role,
                profile,
                provider,
                null,
                null,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        );
    }

    private static void validateUserAccount(User user) {
        if (user.getAccount().getEmail().isBlank() || user.getAccount().getPassword().isBlank()) {
            throw new UserValidationException("이메일과 패스워드는 필수 입력값입니다.");
        }
    }

    private static void validateUserProfile(User user) {
        if (user.getProfile().getNickname().isBlank()) {
            throw new UserValidationException("닉네임은 필수 입력값입니다.");
        }
    }

    public void signIn() {
        lastLoginAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public void signOut() {
        lastLogoutAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public void resign() {
        role = Role.DELETED;
        deletedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public void editProfile(Profile profile) {
        this.profile = profile;
        this.updatedAt = LocalDateTime.now();
    }

}
