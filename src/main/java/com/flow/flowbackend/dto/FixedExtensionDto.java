package com.flow.flowbackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class FixedExtensionDto {
    @Size(max=20)
    @NotBlank
    private String name; // 확장자명
    @NotNull
    private Boolean isBlocked; // 차단 여부
}
