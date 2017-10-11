package com.stv.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {

    SPORTS("Sports"),
    NEWS("News");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    @JsonValue
    private String getValue() {
        return this.value;
    }

    @JsonCreator
    public static Category getType(String value) {
        for (Category type : values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
