package com.et.stackoverflow.controller;

import com.et.stackoverflow.exception.UserNotFoundException;
import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST,value = "/user/create")
    private String  createUser (@RequestBody User user){

        if(userService.findUsername(user.getUserName())!=null){
            String response ="{\"Error\":BAD_REQUEST,\"message\":\"Username already exists \"}";
            return response;
        }
        if(userService.findEmail(user.getEmail())!=null){
            String response ="{\"Error\":BAD_REQUEST,\"message\":\"Email already exists \"}";
            return response;
        }

        user.setTimestamp(new Date());
        userService.createUser(user);
        String response ="{\"success\":true,\"message\":\"USER CREATED SUCCESSFULLY \"}";
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/user/delete/{userId}")
    private String deleteUser(@PathVariable String userId){

        int Id=Integer.parseInt(userId);

        if(userService.findUser(Id)==null) {
            throw new UserNotFoundException("User to be deleted does not exist");
        }
        userService.deleteUser(Id);
        String response ="{\"success\":true,\"message\":\"USER DELETED \"}";
        return response;

    }



}
