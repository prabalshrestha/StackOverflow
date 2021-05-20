package com.et.stackoverflow.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private Date dob;
    private String timestamp;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Question> question=new ArrayList<Question>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  List<Answer> answers=new ArrayList<Answer>();

    public User(){
        super();
    }

    public User(Integer userId, String userName, String password, String email, Date dob, String timestamp, List<Question> question, List<Answer> answers) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.timestamp = timestamp;
        this.question = question;
        this.answers = answers;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
