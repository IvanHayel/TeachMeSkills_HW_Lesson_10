package com.teachmeskills.task_2.resource.exception;

public class WrongLoginException extends AuthenticationException {
    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}