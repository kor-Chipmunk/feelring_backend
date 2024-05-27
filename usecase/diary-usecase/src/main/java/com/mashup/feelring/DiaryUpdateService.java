package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiaryUpdateService implements DiaryUpdateUsecase {

    private final DiaryPort diaryPort;

    @Override
    public Diary update(Request request) {
        return null;
    }
}
