package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping("/question/all")
    private List<Question> getAllQuestions  (){
        List<Question> allQues = questionService.getAllQues();
        return allQues;
    }

    @CrossOrigin
    @GetMapping("/question/{questionId}")
    public Question getQuestion(@PathVariable String questionId){
        int id=Integer.parseInt(questionId);
        return questionService.getQues(id);

    }
    @CrossOrigin
    @PostMapping(value = "/question/create"/*,consumes = {MediaType.APPLICATION_JSON_VALUE}*/)
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
    @CrossOrigin
    @GetMapping("/search")
    public List<Question> search(@RequestBody String keyword){
        return questionService.search(keyword);
    }
}
