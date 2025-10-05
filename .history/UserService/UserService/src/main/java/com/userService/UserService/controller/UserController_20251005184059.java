package com.userService.UserService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.UserService.payload.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    
    @PostMapping()
    public ResponseEntity<ApiResponse> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(ApiResponse.builder().message("User created successfully").success(true).status(201).build());
    }
    
}
