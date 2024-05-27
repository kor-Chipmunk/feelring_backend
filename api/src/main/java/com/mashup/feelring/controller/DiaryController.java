package com.mashup.feelring.controller;

import com.mashup.feelring.model.diary.DiaryCreateRequest;
import com.mashup.feelring.model.diary.DiaryDetailDto;
import com.mashup.feelring.model.diary.DiaryDto;
import com.mashup.feelring.model.diary.DiaryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    @GetMapping
    ResponseEntity<DiaryDetailDto> readDiaries(
            @RequestParam("page") Long page
    ) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<DiaryDto> createDiary(
        @RequestBody DiaryCreateRequest request
    ) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{diaryId}")
    ResponseEntity<DiaryDto> updateDiary(
            @PathVariable("diaryId") Long id,
            @RequestBody DiaryUpdateRequest request
    ) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{diaryId}")
    ResponseEntity<DiaryDto> deleteDiary(
            @PathVariable("diaryId") Long id
    ) {
        return ResponseEntity.ok(null);
    }

}
