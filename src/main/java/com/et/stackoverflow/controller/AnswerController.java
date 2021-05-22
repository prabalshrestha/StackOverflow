package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Answer;
import com.et.stackoverflow.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/question/{questionId}/answer/create")
    public String createAnswer(@PathVariable String questionId ,@RequestBody Answer answer){

        int id=Integer.parseInt(questionId);
        answerService.createAnswer(id,answer);
        String response="{\"success\":true,\"message\":\"ANSWER CREATED\"}";
        return response;
    }
}
