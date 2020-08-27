package com.hrsolutionsystem.hrss.exception.security.passwordHasher;

public class InvalidHashException extends Exception {
    public InvalidHashException(String message) {
        super(message);
    }

    public InvalidHashException(String message, Throwable source) {
        super(message, source);
    }
}
