package com.capstone.EComProductService.exception;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTokenException(String message) {
        super(message);
    }
}
