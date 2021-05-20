package com.et.stackoverflow.service;

import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQues() {
        return questionRepository.getAllPost();
    }
}
