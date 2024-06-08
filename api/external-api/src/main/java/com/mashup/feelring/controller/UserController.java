package com.mashup.feelring.controller;

import com.mashup.feelring.UserCreateUsecase;
import com.mashup.feelring.UserDeleteUsecase;
import com.mashup.feelring.UserReadUsecase;
import com.mashup.feelring.UserUpdateUsecase;
import com.mashup.feelring.config.AuthUser;
import com.mashup.feelring.model.user.*;

import com.mashup.feelring.user.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserCreateUsecase userCreateUsecase;
    private final UserUpdateUsecase userUpdateUsecase;
    private final UserDeleteUsecase userDeleteUsecase;

    @GetMapping
    ResponseEntity<UserDto> read(@AuthUser User user) {
        return ResponseEntity.ok(UserDto.from(user));
    }

    @PostMapping
    ResponseEntity<UserDto> create(
            @RequestBody UserCreateRequest request
    ) {
        User createdUser = userCreateUsecase.create(new UserCreateUsecase.Request(
                request.getEmail(),
                request.getPassword(),
                request.getNickname(),
                request.getImage(),
                request.getProviderType(),
                request.getProviderId()
        ));
        return ResponseEntity.ok(UserDto.from(createdUser));
    }

    @PutMapping
    ResponseEntity<UserDto> update(
            @RequestBody UserUpdateRequest request,
            @AuthUser User user
    ) {
        User updatedUser = userUpdateUsecase.update(new UserUpdateUsecase.Request(
                user.getId().getValue(),
                request.getNickname(),
                request.getImage()
        ));
        return ResponseEntity.ok(UserDto.from(updatedUser));
    }

    @DeleteMapping
    ResponseEntity<UserDto> delete(@AuthUser User user) {
        User deletedUser = userDeleteUsecase.delete(new UserDeleteUsecase.Request(
                user.getId().getValue()
        ));
        return ResponseEntity.ok(UserDto.from(deletedUser));
    }

}
