package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.user.model.User;
import com.mashup.port.DiaryPort;
import com.mashup.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDeleteService implements UserDeleteUsecase {

    private final UserPort userPort;

    @Override
    public User delete(Request request) {
        return null;
    }
}
