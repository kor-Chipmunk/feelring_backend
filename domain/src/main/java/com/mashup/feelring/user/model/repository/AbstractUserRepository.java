package com.mashup.feelring.user.model.repository;

import com.mashup.feelring.user.model.UserId;

public class AbstractUserRepository {
    public static UserId nextId() {
        return new UserId(0L);
    }
}
