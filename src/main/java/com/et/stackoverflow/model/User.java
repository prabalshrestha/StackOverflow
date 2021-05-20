package com.et.stackoverflow.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Users")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private Date dob;
    private String timestamp;

    public User(){
        super();
    }

    public User(Integer userId, String userName, String password, String email, Date dob, String timestamp) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.timestamp = timestamp;
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
}
