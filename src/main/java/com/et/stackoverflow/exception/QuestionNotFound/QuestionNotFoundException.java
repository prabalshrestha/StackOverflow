package com.et.stackoverflow.exception.QuestionNotFound;

public class QuestionNotFoundException extends  RuntimeException{

    public QuestionNotFoundException(String message) {
        super(message);
    }

    public QuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}