package com.et.stackoverflow.service;

import com.et.stackoverflow.exception.QuestionNotFound.QuestionNotFoundException;
import com.et.stackoverflow.model.Answer;
import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.repository.AnswerRepository;
import com.et.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.Date;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void createAnswer(Integer questionId, Answer answer) {
        Question question = questionRepository.findByQuestionId(questionId);
        if(question ==null){
            throw new QuestionNotFoundException("The question entered is invalid");
        }
        answer.setQuestion(question);
        answer.setTimestamp(new Date());
        answerRepository.save(answer);
    }
}
