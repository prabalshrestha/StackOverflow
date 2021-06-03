package com.et.stackoverflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;
    private String questionTitle;
    private String question;


    private Date timestamp;


    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnoreProperties(allowSetters = true)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "question", allowSetters = true)
    private List<Answer> answers=new ArrayList<Answer>();

    public Question(){
        super();
    }

    public Question(Integer questionId, String questionTitle, String question, Date timestamp, User user, List<Answer> answers) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.question = question;
        this.timestamp = timestamp;
        this.user = user;
        this.answers = answers;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}