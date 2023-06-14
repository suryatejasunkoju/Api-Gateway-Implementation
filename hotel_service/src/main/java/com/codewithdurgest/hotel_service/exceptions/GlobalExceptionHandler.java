package com.codewithdurgest.hotel_service.exceptions;

import com.codewithdurgest.hotel_service.DTOs.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus()
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, Object> handlingResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        Map<String,Object> map =new HashMap<>();
        map.put("message", resourceNotFoundException.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return map;
    }
}
