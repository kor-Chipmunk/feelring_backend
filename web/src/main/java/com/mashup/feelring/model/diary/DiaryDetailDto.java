package com.mashup.feelring.model.diary;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DiaryDetailDto {
    private final Long id;
    private final String title;
    private final String nickname;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime deletedAt;
}
