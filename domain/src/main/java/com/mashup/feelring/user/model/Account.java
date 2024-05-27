package com.mashup.feelring.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class Account {

    private String email;
    private String password;

}
