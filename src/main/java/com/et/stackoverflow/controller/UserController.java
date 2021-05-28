package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/user/create")
    private String  createUser (@RequestBody User user){

        user.setTimestamp(new Date());
        user.setRoles("USER");
        userService.createUser(user);
        String response ="{\"success\":true,\"message\":\"USER CREATED SUCCESSFULLY \"}";
        return response;
    }

    @CrossOrigin
    @DeleteMapping("/user/delete/{userId}")
    private String deleteUser(@PathVariable String userId){

        int Id=Integer.parseInt(userId);

        userService.deleteUser(Id);
        String response ="{\"success\":true,\"message\":\"USER DELETED \"}";
        return response;

    }
}
