package com.flipfit.exceptions;

/**
 * Exception thrown when user is invalid
 */
public class UserInvalidException extends Exception {
    public UserInvalidException(String message) {
        super(message);
    }
}