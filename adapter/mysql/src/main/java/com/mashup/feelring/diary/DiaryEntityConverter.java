package com.mashup.feelring.diary;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.diary.model.DiaryId;
import com.mashup.feelring.diary.model.Weather;
import com.mashup.feelring.user.model.UserId;

public class DiaryEntityConverter {

    private DiaryEntityConverter() {}

    public static DiaryEntity toEntity(Diary diary) {
        return new DiaryEntity(
                diary.getId().getValue(),
                diary.getContent(),
                diary.getUserId().getValue(),
                diary.getWeather().name(),
                diary.getHappiness(),
                diary.getCreatedAt(),
                diary.getUpdatedAt(),
                diary.getDeletedAt()
        );
    }

    public static Diary toModel(DiaryEntity diaryEntity) {
        return new Diary(
                new DiaryId(diaryEntity.getId()),
                diaryEntity.getTitle(),
                new UserId(diaryEntity.getUserId()),
                Weather.from(diaryEntity.getCategory()),
                diaryEntity.getHappiness(),
                diaryEntity.getCreatedAt(),
                diaryEntity.getUpdatedAt(),
                diaryEntity.getDeletedAt()
        );
    }

}
