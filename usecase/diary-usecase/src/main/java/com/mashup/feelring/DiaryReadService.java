package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiaryReadService implements DiaryReadUsecase {

    private final DiaryPort diaryPort;

    @Override
    public List<Diary> read(Long page) {
        return List.of();
    }
}
