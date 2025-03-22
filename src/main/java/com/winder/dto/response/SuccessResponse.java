package com.winder.dto.response;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SuccessResponse<T> {
    private int status = 200;
    private String message;
    private T data;

    public SuccessResponse(T data) {
        this.message = "Success";
        this.data = data;
    }

    public SuccessResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public SuccessResponse( int status,String message, T data) {
        this.status=status;
        this.message = message;
        this.data = data;
    }
}