package com.userService.UserService.payload;

import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
