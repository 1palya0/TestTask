package com.example.test.exception;

import lombok.Getter;

@Getter
public class ApplicationException {
    private final String message;

    public ApplicationException(String message) {
        this.message=message;
    }
}
