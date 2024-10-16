package com.flipfit.exceptions;

import static com.flipfit.constant.Constants.RED_COLOR;
import static com.flipfit.constant.Constants.RESET_COLOR;

/**
 * Exception thrown when regisyration fails
 */
public class RegistrationFailedException extends Exception {
    public RegistrationFailedException(String gymOwnerId) {
        super(RED_COLOR+"Failed to register Gym Owner with id: " + gymOwnerId+RESET_COLOR);
    }
}

