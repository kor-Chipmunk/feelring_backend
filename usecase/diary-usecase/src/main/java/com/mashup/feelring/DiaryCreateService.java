package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiaryCreateService implements DiaryCreateUsecase {

    private final DiaryPort diaryPort;

    @Override
    public Diary create(Request request) {
        return null;
    }
}
