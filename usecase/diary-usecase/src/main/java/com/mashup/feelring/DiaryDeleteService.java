package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryDeleteService implements DiaryDeleteUsecase {

    private final DiaryPort diaryPort;

    @Override
    public Diary delete(Request request) {
        Diary deletedDiary = diaryPort.findByUid(request.getUid());
        deletedDiary = diaryPort.delete(deletedDiary);
        return deletedDiary;
    }
}
