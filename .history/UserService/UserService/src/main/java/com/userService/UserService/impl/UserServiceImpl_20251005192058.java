package com.userService.UserService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.UserService.entities.User;
import com.userService.UserService.exceptions.ResourceNotFoundException;
import com.userService.UserService.repository.UserRepository;
import com.userService.UserService.services.UserService;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, ) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
        // Update fields as needed
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // Add other fields as necessary
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
        userRepository.delete(existingUser);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! " + userId));
    }
}