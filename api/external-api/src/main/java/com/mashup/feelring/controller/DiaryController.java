package com.mashup.feelring.controller;

import com.mashup.feelring.DiaryCreateUsecase;
import com.mashup.feelring.DiaryDeleteUsecase;
import com.mashup.feelring.DiaryReadUsecase;
import com.mashup.feelring.DiaryUpdateUsecase;
import com.mashup.feelring.config.AuthUser;
import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.model.diary.DiaryCreateRequest;
import com.mashup.feelring.model.diary.DiaryDto;
import com.mashup.feelring.model.diary.DiaryUpdateRequest;
import com.mashup.feelring.user.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/diaries")
public class DiaryController {

    private final DiaryCreateUsecase diaryCreateUsecase;
    private final DiaryReadUsecase diaryReadUsecase;
    private final DiaryUpdateUsecase diaryUpdateUsecase;
    private final DiaryDeleteUsecase diaryDeleteUsecase;

    @GetMapping
    ResponseEntity<List<DiaryDto>> read(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @AuthUser User user
    ) {
        List<Diary> diaries = diaryReadUsecase.read(user, page, size);
        return ResponseEntity.ok(
                diaries.stream()
                        .map(diary -> DiaryDto.from(diary, user))
                        .toList()
        );
    }

    @PostMapping
    ResponseEntity<DiaryDto> create(
        @RequestBody DiaryCreateRequest request,
        @AuthUser User user
    ) {
        Diary createdDiary = diaryCreateUsecase.create(
                new DiaryCreateUsecase.Request(
                    request.getUid(),
                    user.getId().getValue(),
                    request.getContent(),
                    request.getWeather(),
                    request.getHappiness()
            )
        );
        return ResponseEntity.ok(DiaryDto.from(createdDiary, user));
    }

    @PutMapping("/{diaryUId}")
    ResponseEntity<DiaryDto> update(
            @PathVariable("diaryUId") String uid,
            @RequestBody DiaryUpdateRequest request,
            @AuthUser User user
    ) {
        Diary updatedDiary = diaryUpdateUsecase.update(
                new DiaryUpdateUsecase.Request(
                    request.getUid(),
                    request.getContent(),
                    request.getWeather(),
                    request.getHappiness()
            )
        );
        return ResponseEntity.ok(DiaryDto.from(updatedDiary, user));
    }

    @DeleteMapping("/{diaryUId}")
    ResponseEntity<DiaryDto> delete(
            @PathVariable("diaryUId") String uid,
            @AuthUser User user
    ) {
        Diary deletedDiary = diaryDeleteUsecase.delete(
                new DiaryDeleteUsecase.Request(uid)
        );
        return ResponseEntity.ok(DiaryDto.from(deletedDiary, user));
    }

}
