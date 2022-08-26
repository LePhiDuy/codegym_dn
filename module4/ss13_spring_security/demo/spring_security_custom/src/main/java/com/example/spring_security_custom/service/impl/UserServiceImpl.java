package com.example.spring_security_custom.service.impl;

import com.example.spring_security_custom.model.User;
import com.example.spring_security_custom.repository.UserRepository;
import com.example.spring_security_custom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
