package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import lombok.Data;

public interface DiaryCreateUsecase {
    Diary create(Request request);

    @Data
    class Request {
        private final Long userId;
        private final String title;
    }
}
