package com.flow.flowbackend.dto;

import com.flow.flowbackend.entity.CustomExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CustomExtensionDto {
    private List<CustomExtension> result;
    private int cnt;
}
