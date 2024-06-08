package com.mashup.feelring.controller;

import com.mashup.feelring.AuthLoginUsecase;
import com.mashup.feelring.AuthLoginUsecase.LoginResponse;
import com.mashup.feelring.model.auth.AuthDto;
import com.mashup.feelring.model.auth.AuthRequest;
import com.mashup.feelring.model.user.UserDto;
import com.mashup.feelring.user.model.User;
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

    private final AuthLoginUsecase authLoginUsecase;

    @PostMapping("/login")
    ResponseEntity<AuthDto> login(
            @RequestBody AuthRequest request
    ) {
        AuthLoginUsecase.LoginResponse loginResponse = authLoginUsecase.login(
                new AuthLoginUsecase.Request(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        return ResponseEntity.ok(
                AuthDto.from(
                    loginResponse.getUser(),
                    loginResponse.getAccessToken(),
                    loginResponse.getRefreshToken()
                )
        );
    }

}
