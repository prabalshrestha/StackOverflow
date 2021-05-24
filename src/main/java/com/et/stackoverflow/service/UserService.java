package com.et.stackoverflow.service;

import com.et.stackoverflow.Security.SecurityUtility;
import com.et.stackoverflow.exception.UserNotFound.UserNotFoundException;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {

        if(userRepository.findByUserName(user.getUserName())!=null){
            throw new UserNotFoundException("Username already exists");
        }
        if(userRepository.findByEmail(user.getEmail())!=null){
            throw new UserNotFoundException("Email already exists");
        }
        BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        if(userRepository.findByUserId(userId)==null) {
            throw new UserNotFoundException("User to be deleted does not exist");
        }
        userRepository.deleteById(userId);
    }

    public User findByUsername(String name) {
       return userRepository.findByUserName(name);
    }
}
