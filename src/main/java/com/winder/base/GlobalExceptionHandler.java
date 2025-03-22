package com.winder.base;

import com.winder.dto.response.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getFieldError().getDefaultMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleException(Exception ex) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());


    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message) {
        ErrorResponse errorResponse = new ErrorResponse(status.value(),message);
        return new ResponseEntity<>(errorResponse, status);
    }


}
