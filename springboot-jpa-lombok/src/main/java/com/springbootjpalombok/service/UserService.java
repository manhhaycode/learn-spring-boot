package com.springbootjpalombok.service;

import org.hibernate.exception.DataException;
import org.springframework.stereotype.Service;

import com.springbootjpalombok.model.User;
import com.springbootjpalombok.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    static final String USER_NOT_FOUND = "User not found";
    private final UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    // get user by id
    public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new DataException(USER_NOT_FOUND, null);
        }
        return user;
    }

    // update user by id
    public User updateUserById(User user) {
        User userToUpdate = userRepository.findById(user.getId()).orElse(null);
        if (userToUpdate == null) {
            throw new DataException(USER_NOT_FOUND, null);
        }
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    // Remove user by id
    public String deleteUserById(String id) {
        if (userRepository.removeById(id) == 0) {
            throw new DataException(USER_NOT_FOUND, null);
        }
        return "User deleted";
    }

}
