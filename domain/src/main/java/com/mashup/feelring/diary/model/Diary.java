package com.mashup.feelring.diary.model;

import com.mashup.feelring.user.model.UserId;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Diary {

    private DiaryId id;
    private String title;

    private UserId userId;

    private Weather weather;
    private Integer happiness;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public static Diary write(
            String title,
            UserId userId,
            Weather weather,
            Integer happiness,
            DiaryRepository diaryRepository
    ) {
        return new Diary(
                diaryRepository.nextId(),
                title,
                userId,
                weather,
                happiness,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        );
    }

    public void edit(
            String title,
            Weather weather,
            Integer happiness
    ) {
        this.title = title;
        this.weather = weather;
        this.happiness = happiness;

        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
