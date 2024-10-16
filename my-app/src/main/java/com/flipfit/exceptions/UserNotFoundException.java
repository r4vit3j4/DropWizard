package com.flipfit.exceptions;

import static com.flipfit.constant.Constants.RED_COLOR;
import static com.flipfit.constant.Constants.RESET_COLOR;

/**
 * Exception thrown when User is not found
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message){
        super(message);
        System.out.println(RED_COLOR+"User not found!!"+RESET_COLOR);
    }
}