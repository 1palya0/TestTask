package com.example.test.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
