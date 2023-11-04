package com.flow.flowbackend.config;

import com.flow.flowbackend.dto.ExtensionSortOrder;
import org.springframework.core.convert.converter.Converter;

public class StringToSortOrderEnumConverter implements Converter<String, ExtensionSortOrder> {
    @Override
    public ExtensionSortOrder convert(String source) {
        return ExtensionSortOrder.valueOf(source.toUpperCase());
    }
}
