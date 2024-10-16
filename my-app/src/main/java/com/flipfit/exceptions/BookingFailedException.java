package com.flipfit.exceptions;

import static com.flipfit.constant.Constants.RED_COLOR;
import static com.flipfit.constant.Constants.RESET_COLOR;

/**
 * Exception thrown when Booking fails
 */
public class BookingFailedException extends RuntimeException{
    public BookingFailedException(String message){
        super(RED_COLOR+message+RESET_COLOR);
    }
}