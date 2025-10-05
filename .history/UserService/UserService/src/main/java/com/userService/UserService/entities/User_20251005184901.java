package com.userService.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Table(name = "micro_users")
@Data
@AllArgo
public class User {

    @Id
    @Column(name = "ID")
    private String userId;

    private String name;
    private String email;
    private String about;
}
