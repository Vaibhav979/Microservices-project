package com.userService.UserService.entities;

@Entity
@Table(name = "micro_users")
public class User {
    
    @Id
    @Column(name = "id")
    private String userId;
    private String name;
    private String email;
    private String about;
}
