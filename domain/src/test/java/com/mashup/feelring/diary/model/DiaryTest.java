package com.mashup.feelring.diary.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.mashup.feelring.user.model.UserId;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class DiaryTest {

    @Test
    void write() {
        Diary writtenDiary = Diary.write(
            "제목",
            new UserId(1L),
            Weather.SUNNY,
            1,
            () -> new DiaryId(1L)
        );

        assertAll(
                "writtenDiary",
                () -> assertEquals("제목", writtenDiary.getTitle()),
                () -> assertEquals(new DiaryId(1L), writtenDiary.getId()),
                () -> assertEquals(Weather.SUNNY, writtenDiary.getWeather()),
                () -> assertEquals(1, writtenDiary.getHappiness()),
                () -> assertEquals(new UserId(1L), writtenDiary.getUserId())
        );
    }

    @Test
    void edit() {
        Diary editedDiary = Diary.write(
                "제목",
                new UserId(1L),
                Weather.SUNNY,
                1,
                () -> new DiaryId(1L)
        );

        editedDiary.edit(
                "수정한 제목",
                Weather.CLOUDY,
                2
        );

        assertAll(
                "editedDiary",
                () -> assertEquals("수정한 제목", editedDiary.getTitle()),
                () -> assertEquals(Weather.CLOUDY, editedDiary.getWeather()),
                () -> assertEquals(2, editedDiary.getHappiness())
        );
    }

    @Test
    void delete() {
        LocalDateTime mockNow = LocalDateTime.of(2024,5,27,0,0,0);

        Diary deletedDiary = Diary.write(
                "제목",
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
                    () -> assertEquals(mockNow, deletedDiary.getDeletedAt())
            );
        }
    }

}
