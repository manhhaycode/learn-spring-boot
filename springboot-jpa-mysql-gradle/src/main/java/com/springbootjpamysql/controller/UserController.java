package com.springbootjpamysql.controller;

import java.util.Optional;

import org.hibernate.exception.DataException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjpamysql.model.User;
import com.springbootjpamysql.payload.UserDto;
import com.springbootjpamysql.repository.UserRepository;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/v1") // This means URL's start with /demo (after Application path)
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/create") // Map ONLY POST Requests
    public String addNewUser(@RequestBody UserDto user) {
        User n = new User();
        n.setName(user.getName());
        n.setEmail(user.getEmail());
        userRepository.save(n);
        return "Created";
    }

    @PatchMapping(path = "/update") // Map ONLY POST Requests
    public String updateUser(@RequestBody UserDto user) {
        User n = new User();
        n.setId(user.getId());
        n.setName(user.getName());
        n.setEmail(user.getEmail());
        if (userRepository.existsById(user.getId()))
            userRepository.save(n);
        else
            throw new DataException("User not found", null);
        return "Updated";
    }

    @DeleteMapping(path = "/delete/{id}") // Map ONLY POST Requests
    public String deleteUser(@PathVariable Integer id) {
        User n = new User();
        n.setId(id);

        if (!userRepository.existsById(id))
            throw new DataException("User not found", null);
        else
            userRepository.delete(n);
        return "Deleted";
    }

    @GetMapping(path = "/get")
    public User getUser(@RequestParam Integer id) {
        // This returns a JSON or XML with the users
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new DataException("User not found", null);
        else
            return user.get();
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
