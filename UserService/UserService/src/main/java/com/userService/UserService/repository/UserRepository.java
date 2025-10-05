package com.userService.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userService.UserService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}