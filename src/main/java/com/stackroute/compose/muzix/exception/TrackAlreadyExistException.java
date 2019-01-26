package com.stackroute.compose.muzix.exception;

public class TrackAlreadyExistException extends Exception {
    String message;
    public TrackAlreadyExistException(String message) {
        super(message);
        this.message=message;
    }

}
