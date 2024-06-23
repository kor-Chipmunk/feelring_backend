package com.mashup.feelring.diary.converter;

import com.mashup.feelring.PrivacyEncryptor;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Converter
public class ContentConverter implements AttributeConverter<String, String> {

    private final PrivacyEncryptor privacyEncryptor;

    @Override
    public String convertToDatabaseColumn(String raw) {
        try {
            return privacyEncryptor.encrypt(raw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String encrypted) {
        try {
            return privacyEncryptor.decrypt(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
