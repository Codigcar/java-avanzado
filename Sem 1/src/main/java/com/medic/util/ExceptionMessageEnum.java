package com.medic.util;

public enum ExceptionMessageEnum {

    MODEL_NOT_FOUND("Recurso no encontradooo"),
    INCORRECT_REQUEST("Petición incorrectoa");

    private final String values;

    ExceptionMessageEnum(String values) {
        this.values = values;
    }

    public String getValues() {
        return values;
    }
}
