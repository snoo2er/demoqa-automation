package com.solbegsoft.demoqa.automation.utilities;

public enum Properties {
    USE_DEFAULT_USER;

    private String value;

    Properties(String value) {
        this.value = value;
    }

    Properties() {
        value = this.toString();
    }

    public String getValue() {
        return value;
    }
}
