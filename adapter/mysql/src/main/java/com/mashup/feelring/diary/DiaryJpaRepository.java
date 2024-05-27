package com.mashup.feelring.diary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryJpaRepository extends JpaRepository<DiaryEntity, Long> {
}
