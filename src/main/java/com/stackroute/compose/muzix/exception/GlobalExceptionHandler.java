package com.stackroute.compose.muzix.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exists")
    @ExceptionHandler(TrackAlreadyExistException.class)
    public void handleTrackAlreadyExistException(TrackAlreadyExistException e){
       // log.error("User already exists", e);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track does not exist")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleUserDoesNotExistException(TrackNotFoundException e){
       // log.error("User does not exist", e);
    }
}
