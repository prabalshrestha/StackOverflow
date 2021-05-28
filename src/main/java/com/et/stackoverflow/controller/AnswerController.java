package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Answer;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.AnswerService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/question/{questionId}/answer/create")
    public String createAnswer(@PathVariable String questionId , @RequestBody Answer answer, Principal principal){

        int id=Integer.parseInt(questionId);
        User user=userService.findByUsername(principal.getName());
        answer.setUser(user);
        answerService.createAnswer(id,answer);
        String response="{\"success\":true,\"message\":\"ANSWER CREATED\"}";
        return response;
    }
}
