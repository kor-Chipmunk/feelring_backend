package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiaryDeleteService implements DiaryDeleteUsecase {

    private final DiaryPort diaryPort;

    @Override
    public Diary delete(Request request) {
        return null;
    }
}
