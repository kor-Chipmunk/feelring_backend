package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.user.model.User;
import java.util.List;

public interface DiaryReadUsecase {
    List<Diary> read(User user, int page, int size);
}
