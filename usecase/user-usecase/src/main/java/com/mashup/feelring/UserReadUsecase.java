package com.mashup.feelring;

import com.mashup.feelring.user.model.User;

public interface UserReadUsecase {
    User read(Long id);
    User read(String email);
}
