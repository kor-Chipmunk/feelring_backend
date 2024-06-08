package com.mashup.feelring;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.diary.model.DiaryId;
import com.mashup.feelring.diary.model.Weather;
import com.mashup.feelring.user.model.UserId;
import com.mashup.port.DiaryPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DiaryCreateService implements DiaryCreateUsecase {

    private final DiaryPort diaryPort;

    @Override
    public Diary create(Request request) {
        Diary createdDIary = Diary.write(
                new DiaryId(0L, UUID.fromString(request.getUid())),
                request.getContent(),
                new UserId(request.getUserId()),
                Weather.from(request.getWeather()),
                request.getHappiness()
        );
        return createdDIary;
    }
}
