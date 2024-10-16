package com.flipfit.exceptions;

import java.io.InvalidObjectException;

import static com.flipfit.constant.Constants.RED_COLOR;
import static com.flipfit.constant.Constants.RESET_COLOR;
/**
 * Exception thrown when user selects invalid choice
 */
public class InvalidChoiceException extends InvalidObjectException {
    public InvalidChoiceException(){
        super(RED_COLOR+"Please enter valid choice"+RESET_COLOR);
    }
}