package com.mashup.feelring.user.model;

import com.mashup.feelring.user.model.exception.UserValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Account {

    private String email;
    private String password;

    public Account(String email, String password) {
        validate(email, password);

        this.email = email;
        this.password = password;
    }

    private void validate(String email, String password) {
        if (email.isBlank() || password.isBlank()) {
            throw new UserValidationException("이메일과 패스워드는 필수 입력값입니다.");
        }
    }
}
