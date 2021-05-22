package com.et.stackoverflow.exception.UserNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        UserException userException= new UserException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(Clock.systemDefaultZone())
        );
        return new ResponseEntity<>(userException, badRequest);
    }

}
