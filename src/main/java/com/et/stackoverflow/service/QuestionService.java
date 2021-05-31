package com.et.stackoverflow.service;

import com.et.stackoverflow.exception.QuestionNotFound.QuestionNotFoundException;
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
        List<Question> questionList = questionRepository.findAll();
        if(questionList.isEmpty())
        {
            System.out.println("eeeeeeeee");
            throw new QuestionNotFoundException("Questions does not exist");
        }
        return (List<Question>) questionList;
    }

    public void createQues(Question question) {
        questionRepository.save(question);
    }


    public List<Question> search(String str) {
        return questionRepository.search(str);
    }

    public Question getQues(int id) {

        Question question = questionRepository.findByQuestionId(id);
        if(question==null)
            throw new QuestionNotFoundException("Question Doesnt Exist");
        return question;
    }

    public void editQuestion(Question question) {
        questionRepository.save(question);
    }
}
