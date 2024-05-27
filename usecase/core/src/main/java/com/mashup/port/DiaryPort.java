package com.mashup.port;

import com.mashup.feelring.diary.model.Diary;
import java.util.List;

public interface DiaryPort {
    Diary save(Diary diary);
    List<Diary> findAll(Long page);
}
