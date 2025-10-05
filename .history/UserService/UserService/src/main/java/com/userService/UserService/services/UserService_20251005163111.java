package com.userService.UserService.services;

import java.util.List;

import com.userService.UserService.entities.User;

public interface UserService {
    // Define user-related operations here

    User saveUser(User user);

    List<User> getAllUser(String userId);

    User getUser(String userId);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}