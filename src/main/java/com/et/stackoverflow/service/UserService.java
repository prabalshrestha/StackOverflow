package com.et.stackoverflow.service;

import com.et.stackoverflow.model.User;
import com.et.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User findEmail(String email) {
        return  userRepository.findByEmail(email);
    }

    public User findUser(Integer userId) {
        return userRepository.findByUserId(userId);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
