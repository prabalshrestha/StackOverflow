package com.et.stackoverflow.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer answerId;
    private String answer;
    private Date timestamp;

    @ManyToOne
    private Question question;

    @ManyToOne
    private User user;

    public Answer(Integer answerId, String answer, Date timestamp, Question question, User user) {
        this.answerId = answerId;
        this.answer = answer;
        this.timestamp = timestamp;
        this.question = question;
        this.user = user;
    }

    public Answer(){
        super();
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
