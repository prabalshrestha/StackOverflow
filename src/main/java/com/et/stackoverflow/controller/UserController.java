package com.et.stackoverflow.controller;

import com.et.stackoverflow.exception.UserNotFound.UserNotFoundException;
import com.et.stackoverflow.model.Security.Role;
import com.et.stackoverflow.model.Security.UserRole;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/create")
    private String  createUser (@RequestBody User user){



        user.setTimestamp(new Date());
        Role role=new Role();
        role.setRoleId(1);
        role.setName("ROLE_USER");
        Set<UserRole> userRoles=new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user,userRoles);
        String response ="{\"success\":true,\"message\":\"USER CREATED SUCCESSFULLY \"}";
        return response;
    }

    @DeleteMapping("/user/delete/{userId}")
    private String deleteUser(@PathVariable String userId){

        int Id=Integer.parseInt(userId);

        userService.deleteUser(Id);
        String response ="{\"success\":true,\"message\":\"USER DELETED \"}";
        return response;

    }
}
