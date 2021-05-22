package com.et.stackoverflow.service;

import com.et.stackoverflow.exception.UserNotFound.UserNotFoundException;
import com.et.stackoverflow.model.Security.UserRole;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.repository.RoleRepository;
import com.et.stackoverflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void createUser(User user, Set<UserRole> userRoles) {

        if(userRepository.findByUserName(user.getUserName())!=null){
            throw new UserNotFoundException("Username already exists");
        }
        if(userRepository.findByEmail(user.getEmail())!=null){
            throw new UserNotFoundException("Email already exists");
        }
        for(UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
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
}
