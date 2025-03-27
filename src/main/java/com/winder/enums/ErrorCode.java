package com.winder.enums;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error",HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error",HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed",HttpStatus.NOT_FOUND),

    USERNAME_INVALID(1003, "Username must be at least 3 characters",HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters",HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1006,"Email is not in the right format",HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1007, "Unauthenticated",HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED(1007, "Access denied ",HttpStatus.FORBIDDEN),


    ROLE_NOT_EXISTED(1002, "Role not existed",HttpStatus.NOT_FOUND),
    ;

    ErrorCode(int code, String message,HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode= statusCode;
    }

    @Getter
    private int code;
    @Getter
    private String message;

    @Getter
    private HttpStatusCode statusCode;

}