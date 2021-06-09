package com.et.stackoverflow.exception.QuestionNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.ZonedDateTime;

@ControllerAdvice
public class QuestionNotFoundExecptionHandler {

    @ExceptionHandler(value = {QuestionNotFoundException.class})
    public ResponseEntity<Object> handleQuestionNotFoundException(QuestionNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        QuestionException questionException= new QuestionException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(Clock.systemDefaultZone())
        );
        return new ResponseEntity<>(questionException, badRequest);
    }
}