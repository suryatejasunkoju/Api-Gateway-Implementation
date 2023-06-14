package com.codewithdurgesh.user_service.controllers;

import com.codewithdurgesh.user_service.entities.User;
import com.codewithdurgesh.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long id){
        return userService.getUser(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
