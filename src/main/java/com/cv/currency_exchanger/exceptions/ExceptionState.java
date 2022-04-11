package com.cv.currency_exchanger.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionState {

    SUCCESS("passed validations"),
    INVALID_AMOUNT("Amount must be above 0"),
    INVALID_CURRENCY("Currency doesn't exist");

    private String description;

    ExceptionState(String description) {
        this.description = description;
    }
}
