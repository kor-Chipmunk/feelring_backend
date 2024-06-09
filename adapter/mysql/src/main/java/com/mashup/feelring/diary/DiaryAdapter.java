package com.mashup.feelring.diary;

import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.exception.BusinessException;
import com.mashup.feelring.exception.ErrorCode;
import com.mashup.port.DiaryPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DiaryAdapter implements DiaryPort {

    private final DiaryJpaRepository diaryJpaRepository;

    @Override
    @Transactional
    public Diary save(Diary user) {
        DiaryEntity userEntity = diaryJpaRepository.save(DiaryEntityConverter.toEntity(user));
        return DiaryEntityConverter.toModel(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Diary> findAll(Long userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<DiaryEntity> diaryEntities = diaryJpaRepository.findByUserIdOrderByIdDesc(userId, pageRequest);
        return diaryEntities.getContent().stream()
                .map(DiaryEntityConverter::toModel)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Diary findByUid(String uid) {
        DiaryEntity diaryEntity = diaryJpaRepository.findByUid(uid).orElse(null);
        if (diaryEntity == null) throw BusinessException.from(ErrorCode.DIARY_NOT_FOUND);
        return DiaryEntityConverter.toModel(diaryEntity);
    }

    @Override
    @Transactional
    public Diary delete(Diary diary) {
        DiaryEntity diaryEntity = diaryJpaRepository.findByUid(
                diary.getId().getUid().toString()
        ).orElse(null);
        if (diaryEntity == null) throw BusinessException.from(ErrorCode.DIARY_NOT_FOUND);
        diaryJpaRepository.delete(diaryEntity);
        return DiaryEntityConverter.toModel(diaryEntity);
    }
}
