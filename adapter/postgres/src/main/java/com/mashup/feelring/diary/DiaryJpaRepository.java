package com.mashup.feelring.diary;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<DiaryEntity, Long> {
    Optional<DiaryEntity> findByUid(String uid);
    Page<DiaryEntity> findByUserIdOrderByIdDesc(Long userId, Pageable pageable);
    List<DiaryEntity> findByUidIn(List<String> uid);
}
