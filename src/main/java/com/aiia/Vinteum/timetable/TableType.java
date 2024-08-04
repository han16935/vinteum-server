package com.aiia.Vinteum.timetable;

public enum TableType {
    NORMAL("일반"),

    CUSTOM("맞춤");

    private final String description;

    TableType(String description) {
        this.description = description;
    }
}
