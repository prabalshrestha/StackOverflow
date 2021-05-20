package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(method = RequestMethod.GET,value = "/question/all")
    private List<Question> getAllQuestions  (){
        return questionService.getAllQues();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/question/create")
    public String createQuestion(@RequestBody Question question){


        question.setTimestamp(new Date());
        questionService.createQues(question);
        String response ="{\"success\":true,\"message\":\"Question successfully added\"}";
        return response;
    }
}
