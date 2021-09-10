package com.example.tutormatch.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Specialty {
    PRESCHOOL("PRE-K"), PRIMARY("PRIMARY"), SECONDARY("SECONDARY"), POST_SECONDARY("POST");

    private String spec;

    private Specialty(String spec) {
        this.spec = spec;
    }

        @JsonCreator
        public static Specialty decode(final String spec){
            return Stream.of(Specialty.values()).filter(targetEnum -> targetEnum.spec.equals(spec)).findFirst().orElse(null);
        }

        @JsonValue
        public String getCode () {
            return spec;
        }
}

