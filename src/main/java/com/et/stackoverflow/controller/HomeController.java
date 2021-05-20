package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST,value = "/user/create")
    private String  createUser (@RequestBody User user){
        user.setTimestamp(new Date());
        userService.createUser(user);
        String response ="{\"success\":true,\"message\":\"Account successfully created \"}";
        return response;
    }



}
