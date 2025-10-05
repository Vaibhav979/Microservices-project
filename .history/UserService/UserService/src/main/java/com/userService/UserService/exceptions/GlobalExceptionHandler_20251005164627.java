package com.userService.UserService.exceptions;

import org.springframework.http.ResponseEntity;

import com.userService.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @Exception()
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException() {
        
    }
}
