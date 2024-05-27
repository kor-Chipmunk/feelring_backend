package com.mashup.feelring.user.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class UserTest {

    @Test
    void signUp() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            User signUpUser = User.signUp(
                    new Account(
                            "test@naver.com",
                            "123456"
                    ),
                    Role.USER,
                    new Profile(
                            "닉네임",
                            "https://cdn.feelring.com/abc.png"
                    ),
                    () -> new UserId(1L)
            );

            assertAll("signUpUser",
                    () -> assertEquals(new UserId(1L), signUpUser.getId()),
                    () -> assertEquals("test@naver.com", signUpUser.getAccount().getEmail()),
                    () -> assertEquals("123456", signUpUser.getAccount().getPassword()),
                    () -> assertEquals(Role.USER, signUpUser.getRole()),
                    () -> assertEquals("닉네임", signUpUser.getProfile().getNickname()),
                    () -> assertEquals("https://cdn.feelring.com/abc.png", signUpUser.getProfile().getImage()),
                    () -> assertEquals(mockNow, signUpUser.getCreatedAt()),
                    () -> assertEquals(mockNow, signUpUser.getUpdatedAt())
            );
        }
    }

    @Test
    void signIn() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            User signInUser = User.signUp(
                    new Account(
                            "test@naver.com",
                            "123456"
                    ),
                    Role.USER,
                    new Profile(
                            "닉네임",
                            "https://cdn.feelring.com/abc.png"
                    ),
                    () -> new UserId(1L)
            );

            signInUser.signIn();

            assertAll("signInUser",
                    () -> assertEquals(mockNow, signInUser.getLastLoginAt()),
                    () -> assertEquals(mockNow, signInUser.getUpdatedAt())
            );
        }
    }

    @Test
    void signOut() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            User signOutUser = User.signUp(
                    new Account(
                            "test@naver.com",
                            "123456"
                    ),
                    Role.USER,
                    new Profile(
                            "닉네임",
                            "https://cdn.feelring.com/abc.png"
                    ),
                    () -> new UserId(1L)
            );

            signOutUser.signOut();

            assertAll("signInUser",
                    () -> assertEquals(mockNow, signOutUser.getLastLogoutAt()),
                    () -> assertEquals(mockNow, signOutUser.getUpdatedAt())
            );
        }
    }

    @Test
    void resign() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            User resignUser = User.signUp(
                    new Account(
                            "test@naver.com",
                            "123456"
                    ),
                    Role.USER,
                    new Profile(
                            "닉네임",
                            "https://cdn.feelring.com/abc.png"
                    ),
                    () -> new UserId(1L)
            );

            resignUser.resign();

            assertAll("signInUser",
                    () -> assertEquals(Role.DELETED, resignUser.getRole()),
                    () -> assertEquals(mockNow, resignUser.getDeletedAt()),
                    () -> assertEquals(mockNow, resignUser.getUpdatedAt())
            );
        }
    }

    @Test
    void editProfile() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            User edittedUser = User.signUp(
                    new Account(
                            "test@naver.com",
                            "123456"
                    ),
                    Role.USER,
                    new Profile(
                            "닉네임",
                            "https://cdn.feelring.com/abc.png"
                    ),
                    () -> new UserId(1L)
            );

            edittedUser.editProfile(
                    new Profile(
                            "변경한닉네임",
                            "https://cdn.feelring.com/def.png"
                    )
            );

            assertAll("signInUser",
                    () -> assertEquals("변경한닉네임", edittedUser.getProfile().getNickname()),
                    () -> assertEquals("https://cdn.feelring.com/def.png", edittedUser.getProfile().getImage()),
                    () -> assertEquals(mockNow, edittedUser.getUpdatedAt())
            );
        }
    }
}
