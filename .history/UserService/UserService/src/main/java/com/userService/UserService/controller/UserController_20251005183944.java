package com.userService.UserService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping()
    public ResponseEntity postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
