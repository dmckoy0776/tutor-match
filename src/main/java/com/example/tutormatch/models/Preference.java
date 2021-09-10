package com.example.tutormatch.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Preference {
    VIRTUAL("V"), IN_PERSON("P");

    private String pref;

    private Preference(String pref) {
        this.pref=pref;
    }

    @JsonCreator
    public static Preference decode(final String pref) {
        return Stream.of(Preference.values()).filter(targetEnum -> targetEnum.pref.equals(pref)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return pref;
    }

}
