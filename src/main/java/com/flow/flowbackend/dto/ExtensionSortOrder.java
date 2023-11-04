package com.flow.flowbackend.dto;

import org.springframework.data.domain.Sort;

public enum ExtensionSortOrder {
    ASC,
    DESC
    ;

    public Sort.Direction toDirection(){
        if (this == ASC) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }
}
