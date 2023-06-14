package com.codewithdurgesh.user_service.service;

import com.codewithdurgesh.user_service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
}
