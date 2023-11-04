package com.flow.flowbackend.config;

import com.flow.flowbackend.dto.ExtensionSortBy;
import org.springframework.core.convert.converter.Converter;

public class StringToSortByEnumConverter implements Converter<String, ExtensionSortBy> {
    @Override
    public ExtensionSortBy convert(String source) {
        return ExtensionSortBy.valueOf(source.toUpperCase());
    }
}
