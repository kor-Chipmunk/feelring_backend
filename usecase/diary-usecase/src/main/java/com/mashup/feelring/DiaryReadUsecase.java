package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import java.util.List;
import lombok.Data;

public interface DiaryReadUsecase {
    List<Diary> read(Long page);
}
