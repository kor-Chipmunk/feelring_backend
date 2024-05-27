package com.mashup.feelring.model.diary;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DiaryDto {
    private final Long id;
    private final String title;
    private final Long userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime deletedAt;
}
