package com.mashup.feelring.diary.model;

import com.mashup.feelring.user.model.UserId;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Diary {

    public static final int MAX_CONTENT_LENGTH = 128;

    private DiaryId id;
    private String content;

    private UserId userId;

    private Weather weather;
    private Integer happiness;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public static Diary write(
            String content,
            UserId userId,
            Weather weather,
            Integer happiness,
            DiaryRepository diaryRepository
    ) {
        validateContentSize(content);

        return new Diary(
                diaryRepository.nextId(),
                content,
                userId,
                weather,
                happiness,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        );
    }

    private static void validateContentSize(String content) {
        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new IllegalArgumentException("일기 내용이 최대 길이를 초과했습니다.");
        }
    }

    public void edit(
            String content,
            Weather weather,
            Integer happiness
    ) {
        validateContentSize(content);

        this.content = content;
        this.weather = weather;
        this.happiness = happiness;

        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
