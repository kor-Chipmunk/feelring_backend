package com.mashup.feelring.diary;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<DiaryEntity, Long> {
    Optional<DiaryEntity> findByUid(String uid);
    Page<DiaryEntity> findByUserId(Long userId, Pageable pageable);
}
