package com.simple.main.exception;

public class SimpleException extends RuntimeException {
 
    private String message;
 
    public SimpleException(Throwable throwable) {
        super(throwable);
    }
 
    public SimpleException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}