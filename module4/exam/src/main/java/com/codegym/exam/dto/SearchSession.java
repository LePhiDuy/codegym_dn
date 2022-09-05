package com.codegym.exam.dto;


public class SearchSession {
    private String value;

    public SearchSession() {
    }

    public SearchSession(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}