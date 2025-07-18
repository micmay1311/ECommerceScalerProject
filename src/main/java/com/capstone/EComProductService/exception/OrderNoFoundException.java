package com.capstone.EComProductService.exception;

public class OrderNoFoundException extends Exception{

    public OrderNoFoundException() {
        super();
    }

    public OrderNoFoundException(String message) {
        super(message);
    }

    public OrderNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
