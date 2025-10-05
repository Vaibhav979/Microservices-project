package com.userService.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name = "micro_users")
public class User {
    
    @Id
    @Column(name = "ID")
    private String userId;
    
    private String name;
    private String email;
    private String about;
}
