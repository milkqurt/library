package com.example.samgau_test.entity;

public enum Genre {
    Horror("horror"),
    Comics("comics"),
    Study("study");

    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
