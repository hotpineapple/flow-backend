package com.flow.flowbackend.dto;
public enum ExtensionSortBy {
    NAME("name"),
    ADDED_AT("addedAt")
    ;

    public final String value;

    ExtensionSortBy(String value) {
        this.value = value;
    }
}