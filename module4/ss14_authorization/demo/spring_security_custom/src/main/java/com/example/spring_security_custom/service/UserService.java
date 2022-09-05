package com.example.spring_security_custom.service;


import com.example.spring_security_custom.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
//    void save(User user);
//    void update(User user);
    User findById(int id);
}
