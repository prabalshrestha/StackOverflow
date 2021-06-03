package com.et.stackoverflow.controller;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.model.User;
import com.et.stackoverflow.service.QuestionService;
import com.et.stackoverflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

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
    @PostMapping(value = "/question/create")
    public String createQuestion(@RequestBody Question question, Principal principal){
        User user = userService.findByUsername(principal.getName());
        question.setUser(user);
        question.setTimestamp(new Date());
        questionService.createQues(question);
        String response ="{\"success\":true,\"message\":\"Question successfully added\"}";
        return response;
    }
    @CrossOrigin
    @GetMapping("/search/")
    public List<Question> search(@RequestParam String keyword){
        return questionService.search(keyword);
    }


    @CrossOrigin
    @PutMapping("/question/{questionId}")
    public String EditQuestion(@PathVariable String questionId,@RequestBody Question question,Principal principal){
        int quesId=Integer.parseInt(questionId);
        User user= userService.findUsername(principal.getName());
        question.setQuestionId(quesId);
        question.setTimestamp(new Date());
        question.setUser(user);
        questionService.editQuestion(question,quesId);
        String response ="{\"success\":true,\"message\":\"Question successfully Edited\"}";
        return response;
    }

    @CrossOrigin
    @DeleteMapping("/question/{questionId}")
    public String deleteQuestion(@PathVariable String questionId){
        int id=Integer.parseInt(questionId);
        questionService.delete(id);
        String response ="{\"success\":true,\"message\":\"Question successfully Deleted\"}";
        return response;

    }



}
