package com.userService.UserService.services;


public interface UserService {
    // Define user-related operations here

    User saveUser(User user);

    List<User> getAlllUser(String userId);

    User getUser(String userId);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}