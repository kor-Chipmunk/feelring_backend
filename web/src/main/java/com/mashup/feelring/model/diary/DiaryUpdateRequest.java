package com.mashup.feelring.model.diary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiaryUpdateRequest {
    private String title;
    private Long userId;
}
