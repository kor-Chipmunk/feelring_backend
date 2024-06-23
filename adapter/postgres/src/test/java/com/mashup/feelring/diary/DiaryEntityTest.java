package com.mashup.feelring.diary;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mashup.feelring.DataJpaConfig;
import com.mashup.feelring.PrivacyEncryptor;
import com.mashup.feelring.diary.model.Diary;
import com.mashup.feelring.diary.model.DiaryId;
import com.mashup.feelring.diary.model.Weather;
import com.mashup.feelring.user.model.UserId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {DataJpaConfig.class})
@DataJpaTest
class DiaryEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private PrivacyEncryptor privacyEncryptor;

    @Test
    @DisplayName("일기 내용은 암호화되어야 한다.")
    void shouldEncryptDiaryContent() throws Exception {
        final String privacyContent = "사적이고 민감한 내용이 담긴 일기입니다.";
        final String encryptContent = "암호화한 데이터입니다.";

        when(privacyEncryptor.encrypt(anyString())).thenReturn(encryptContent);
        when(privacyEncryptor.decrypt(anyString())).thenReturn(privacyContent);

        final Diary privacyDiary = Diary.write(
                new DiaryId(null, UUID.randomUUID()),
                privacyContent,
                new UserId(1L),
                Weather.SUNNY
        );

        final DiaryEntity privacyDiaryEntity = DiaryEntityConverter.toEntity(privacyDiary);

        entityManager.persist(privacyDiaryEntity);
        entityManager.flush();
        entityManager.clear();

        final EntityManager em = entityManager.getEntityManager();
        Query query = em.createNativeQuery("SELECT content From Diary WHERE id = :id");
        query.setParameter("id", privacyDiaryEntity.getId());
        String actual = (String) query.getSingleResult();

        assertNotNull(privacyDiaryEntity);
        assertEquals(encryptContent, actual);
    }
}
