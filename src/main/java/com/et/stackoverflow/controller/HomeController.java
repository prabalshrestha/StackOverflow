package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;

import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/user/create")
    private String  createUser (@RequestBody User user){
        user.setTimestamp(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userService.createUser(user);
        String response ="{\"success\":true,\"message\":\"Account successfully created \"}";
        return response;
    }

    @RolesAllowed("USER")
    @RequestMapping("/user/dashboard")
    private String dashboard(Model model)
    {
        return "dashboard";

    }



}
