package com.userService.UserService.exceptions;

import org.springframework.http.ResponseEntity;

import com.userService.UserService.payload.ApiResponse;

@Rest
public class GlobalExceptionHandler {
    
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException() {
        
    }
}
