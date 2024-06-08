package com.mashup.feelring.user.model;

import com.mashup.feelring.user.model.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private UserId id;
    private Account account;
    private Role role;
    private Profile profile;
    private Provider provider;

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
