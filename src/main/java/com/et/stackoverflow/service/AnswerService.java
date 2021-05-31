package com.et.stackoverflow.service;

import com.et.stackoverflow.exception.QuestionNotFound.QuestionNotFoundException;
import com.et.stackoverflow.model.Answer;
import com.et.stackoverflow.model.Question;
import com.et.stackoverflow.repository.AnswerRepository;
import com.et.stackoverflow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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


    public List<Answer> getAnswers(int questionId) {
        List<Answer> answers = answerRepository.findAnswersByQuestion_QuestionId(questionId);
        if(answers.isEmpty())
            throw new QuestionNotFoundException("Question doesnt Exists");
        return answers;
    }
}
