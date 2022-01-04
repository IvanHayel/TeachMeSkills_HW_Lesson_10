package com.teachmeskills.task_2.resource.exception;

public class WrongPasswordException extends AuthenticationException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}