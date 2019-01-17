package com.stackroute.MuzixApplication.exception;

public class TrackNotFindException extends  Exception{

    private String message;
    public TrackNotFindException(){}

    public TrackNotFindException(String tracknotfound) {
        super(tracknotfound);
        this.message = tracknotfound;
    }
}
