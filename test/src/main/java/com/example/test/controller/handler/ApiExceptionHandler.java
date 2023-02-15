package com.example.test.controller.handler;

import com.example.test.exception.ApiException;
import com.example.test.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={ApiException.class})
    public ResponseEntity<?> HandleException(ApiException exception){
        log.error("throws exception");
        ApplicationException exception1=new ApplicationException(exception.getMessage());
        return ResponseEntity.badRequest().body(exception1);
    }
}
