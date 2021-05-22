package com.et.stackoverflow.controller;

import com.et.stackoverflow.exception.QuestionNotFound.QuestionNotFoundException;
import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping("/question/all")
    private List<Question> getAllQuestions  (){
        List<Question> allQues = questionService.getAllQues();
        return allQues;
    }

    @PostMapping("/question/create")
    public String createQuestion(@RequestBody Question question){
        question.setTimestamp(new Date());
        questionService.createQues(question);
        String response ="{\"success\":true,\"message\":\"Question successfully added\"}";
        return response;
    }
}
