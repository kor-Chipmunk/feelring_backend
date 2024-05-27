package com.mashup.feelring.diary.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

import com.mashup.feelring.user.model.UserId;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

@DisplayName("일기를")
class DiaryTest {

    @Test
    void 작성합니다() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            Diary writtenDiary = Diary.write(
                    "내용",
                    new UserId(1L),
                    Weather.SUNNY,
                    1,
                    () -> new DiaryId(1L)
            );

            assertAll(
                    "writtenDiary",
                    () -> assertEquals("내용", writtenDiary.getContent()),
                    () -> assertEquals(new DiaryId(1L), writtenDiary.getId()),
                    () -> assertEquals(Weather.SUNNY, writtenDiary.getWeather()),
                    () -> assertEquals(1, writtenDiary.getHappiness()),
                    () -> assertEquals(new UserId(1L), writtenDiary.getUserId()),
                    () -> assertEquals(mockNow, writtenDiary.getCreatedAt()),
                    () -> assertEquals(mockNow, writtenDiary.getUpdatedAt())
            );
        }
    }

    @Test
    void 내용은_최대_길이를_넘으면_예외를_일으킵니다() {
        assertThrows(IllegalArgumentException.class, () -> {
            Diary.write(
                    "가".repeat(Diary.MAX_CONTENT_LENGTH + 1),
                    new UserId(1L),
                    Weather.SUNNY,
                    1,
                    () -> new DiaryId(1L)
            );
        });
    }

    @Test
    void 수정합니다() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        Diary editedDiary = Diary.write(
                "내용",
                new UserId(1L),
                Weather.SUNNY,
                1,
                () -> new DiaryId(1L)
        );

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            editedDiary.edit(
                    "수정한 내용",
                    Weather.CLOUDY,
                    2
            );

            assertAll(
                    "editedDiary",
                    () -> assertEquals("수정한 내용", editedDiary.getContent()),
                    () -> assertEquals(Weather.CLOUDY, editedDiary.getWeather()),
                    () -> assertEquals(2, editedDiary.getHappiness()),
                    () -> assertEquals(mockNow, editedDiary.getUpdatedAt())
            );
        }
    }

    @Test
    void 삭제합니다() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        Diary deletedDiary = Diary.write(
                "내용",
                new UserId(1L),
                Weather.SUNNY,
                1,
                () -> new DiaryId(1L)
        );

        try (MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(mockNow);

            deletedDiary.delete();

            assertAll(
                    "deletedDiary",
                    () -> assertEquals(mockNow, deletedDiary.getDeletedAt()),
                    () -> assertEquals(mockNow, deletedDiary.getUpdatedAt())
            );
        }
    }

}
