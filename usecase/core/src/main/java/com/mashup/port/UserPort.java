package com.mashup.port;

import com.mashup.feelring.user.model.User;

public interface UserPort {
    User save(User user);
    User findById(Long id);
}
