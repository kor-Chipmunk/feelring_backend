package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import lombok.Data;

public interface DiaryDeleteUsecase {
    Diary delete(Request request);

    @Data
    class Request {
        private final String uid;
    }
}
