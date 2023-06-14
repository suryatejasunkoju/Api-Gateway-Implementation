package com.codewithdurgesh.user_service.exceptions;

import com.codewithdurgesh.user_service.DTOs.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus()
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse handlingResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return ApiResponse.builder()
                .message(resourceNotFoundException.getMessage())
                .success(false)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
    }
}
