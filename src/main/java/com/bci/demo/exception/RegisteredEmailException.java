package com.bci.demo.exception;

public class RegisteredEmailException extends RuntimeException {

    public RegisteredEmailException(final String email) {
        super(String.format("Email %s is already registered", email));
    }

}
