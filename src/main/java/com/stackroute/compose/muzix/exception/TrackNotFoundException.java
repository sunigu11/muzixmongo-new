package com.stackroute.compose.muzix.exception;

public class TrackNotFoundException extends Exception {
    private String message;
    public TrackNotFoundException(){}
    public TrackNotFoundException(String message) {
        this.message = message;
    }
}
