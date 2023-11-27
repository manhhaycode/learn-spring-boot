package com.springbootjpalombok.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjpalombok.model.User;
import com.springbootjpalombok.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping("/update")
    public User updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }

}
