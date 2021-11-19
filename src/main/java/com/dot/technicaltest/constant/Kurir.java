package com.dot.technicaltest.constant;

public enum  Kurir {
    JNE("jne"),
    POS("pos"),
    TIKI("tiki");

    private final String value;

    @Override
    public String toString() {
        return value;
    }

    Kurir(String value) {
        this.value = value;
    }

    }
