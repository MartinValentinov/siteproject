package com.example.mysite.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyUserRepository extends MongoRepository<MyUser, String> {
    MyUser findByUsername(String username);
}