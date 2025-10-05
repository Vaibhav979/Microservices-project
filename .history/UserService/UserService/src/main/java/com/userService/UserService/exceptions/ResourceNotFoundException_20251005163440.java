package com.userService.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }
}
