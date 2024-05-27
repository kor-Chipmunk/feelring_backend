package com.mashup.feelring.diary;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.port.DiaryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DiaryAdapter implements DiaryPort {

    private final DiaryJpaRepository diaryJpaRepository;

    @Transactional
    @Override
    public Diary save(Diary user) {
        DiaryEntity userEntity = diaryJpaRepository.save(DiaryEntityConverter.toEntity(user));
        return DiaryEntityConverter.toModel(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Diary> findAll(Long page) {
        DiaryEntity userEntity = diaryJpaRepository.findById(page).orElse(null);
        if (userEntity == null) return null;

        return List.of();
    }
}
