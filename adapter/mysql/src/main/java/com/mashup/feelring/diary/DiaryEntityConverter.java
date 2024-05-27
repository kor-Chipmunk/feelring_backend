package com.mashup.feelring.diary;

import com.mashup.feelring.diary.model.Diary;

public class DiaryEntityConverter {

    private DiaryEntityConverter() {}

    public static DiaryEntity toEntity(Diary diary) {
        return new DiaryEntity(
                diary.getId(),
                diary.getTitle(),
                diary.getUserId(),
                diary.getCategory(),
                diary.getHappiness(),
                diary.getCreatedAt(),
                diary.getUpdatedAt(),
                diary.getDeletedAt()
        );
    }

    public static Diary toModel(DiaryEntity diaryEntity) {
        return new Diary(
                diaryEntity.getId(),
                diaryEntity.getTitle(),
                diaryEntity.getUserId(),
                diaryEntity.getCategory(),
                diaryEntity.getHappiness(),
                diaryEntity.getCreatedAt(),
                diaryEntity.getUpdatedAt(),
                diaryEntity.getDeletedAt()
        );
    }

}
