package com.riakhin.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year year) {
        return year != null ? (short)year.getValue() : null;
    }
    @Override
    public Year convertToEntityAttribute(Short year) {
        return year != null ? Year.of(year) : null;
    }
}
