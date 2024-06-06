package com.mashup.feelring.controller;

import com.mashup.feelring.model.user.*;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    ResponseEntity<UserDto> readUser() {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<UserDto> createUser(
            @RequestBody UserCreateRequest request
    ) {
        return ResponseEntity.ok(null);
    }

    @PutMapping
    ResponseEntity<UserDto> updateUser(
            @RequestBody UserUpdateRequest request
    ) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    ResponseEntity<UserDto> deleteUser() {
        return ResponseEntity.ok(null);
    }

}
