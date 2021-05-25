package com.et.stackoverflow.exception.UserNotFound;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class UserException {
    private final String message;
    private final String messageCode;
    private final HttpStatus httpStatus;

    private final ZonedDateTime timestamp;

    public UserException(String message, String messageCode, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.messageCode = messageCode;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
