package com.example.demo.entites;

public class UnauthorizedActionException extends RuntimeException {

    public UnauthorizedActionException() {
        super();
    }

    public UnauthorizedActionException(String message) {
        super(message);
    }

    public UnauthorizedActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedActionException(Throwable cause) {
        super(cause);
    }
}

