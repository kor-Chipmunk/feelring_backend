package com.mashup.feelring.model.diary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiaryCreateRequest {
    private String title;
    private Long userId;
}
