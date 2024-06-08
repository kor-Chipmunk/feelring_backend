package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import lombok.Data;

public interface DiaryRegisterAlarmUsecase {
    Diary registerAlarm(Request request);

    @Data
    class Request {
        private final String uid;
        private final String alarmUrl;
    }
}
