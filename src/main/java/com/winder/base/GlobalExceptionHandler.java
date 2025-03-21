package com.winder.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException){
        return buildResponseEntity(HttpStatus.BAD_REQUEST,  runtimeException);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<Object> handleGeneralException(Exception ex){
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,  ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, status);
    }
}
