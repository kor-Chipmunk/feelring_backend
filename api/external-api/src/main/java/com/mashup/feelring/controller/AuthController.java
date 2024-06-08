package com.mashup.feelring.controller;

import com.mashup.feelring.model.auth.AuthRequest;
import com.mashup.feelring.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/login")
    ResponseEntity<UserDto> login(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(UserDto.from(null));
    }

}
