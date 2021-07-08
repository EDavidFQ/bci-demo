package com.bci.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = RegisteredEmailException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> registeredEmailException(RegisteredEmailException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return response;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> argumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("message", exception.getFieldError().getDefaultMessage());
        return response;
    }

}
