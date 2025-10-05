package com.userService.UserService.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.userService.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler()
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException() {
        
    }
}
