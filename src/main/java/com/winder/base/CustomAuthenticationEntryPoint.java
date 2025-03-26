package com.winder.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winder.dto.response.ApiResponse;
import com.winder.enums.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        log.info("Responding with unauthorized error. Message - {}", e.getMessage());
        ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;

        httpServletResponse.setStatus(ErrorCode.UNAUTHENTICATED.getStatusCode().value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(apiResponse));

    }

}