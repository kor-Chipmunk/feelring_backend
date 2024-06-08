package com.mashup.feelring.diary.model;

import com.mashup.feelring.diary.exception.DiaryValidationException;
import com.mashup.feelring.user.model.UserId;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Diary {

    public static final int MAX_CONTENT_LENGTH = 128;

    @NonNull private DiaryId id;
    @NonNull private String content;

    @NonNull private UserId userId;

    @NonNull private Weather weather;
    @NonNull private Integer happiness;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public static Diary write(
            DiaryId id,
            String content,
            UserId userId,
            Weather weather,
            Integer happiness
    ) throws DiaryValidationException {
        validateContentSize(content);

        return new Diary(
                id,
                content,
                userId,
                weather,
                happiness,
                LocalDateTime.now(),
                LocalDateTime.now(),
                null
        );
    }

    private static void validateContentSize(String content) throws DiaryValidationException {
        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new DiaryValidationException("일기 내용이 최대 길이를 초과했습니다.");
        }
    }

    public void edit(
            String content,
            Weather weather,
            Integer happiness
    ) throws DiaryValidationException {
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
