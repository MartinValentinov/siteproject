package com.example.mysite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") // MongoDB collection name
public class MyUser {

    @Id
    private String id; // MongoDB automatically generates String IDs

    private String username;
    private String password;
    private String role; // e.g., ADMIN, USER

    public MyUser() {}

    public MyUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password;}

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}