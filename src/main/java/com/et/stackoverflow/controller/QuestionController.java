package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/question/all")
    private List<Question> getAllQuestions  (){
        List<Question> allQues = questionService.getAllQues();
        return allQues;
    }

    @PostMapping("/question/create")
    public Map<String,String> createQuestion(@RequestBody Question question,
                                             Principal principal){
        User user = userService.findByUsername(principal.getName());
        question.setUser(user);
        question.setTimestamp(new Date());
        questionService.createQues(question);
        /*String response ="{\"success\":true,\"message\":\"Question successfully added\"}";*/
        Map<String,String> response=new HashMap<>();
        response.put("success","true");
        response.put("message","Question successfully added");

        return response;
    }
}
