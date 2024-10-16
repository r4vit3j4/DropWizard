package com.flipfit.dao;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.exceptions.RegistrationFailedException;
import com.flipfit.exceptions.UserInvalidException;
/**
 * Data Access Object (DAO) interface for handling customer-related operations in FlipFit system.
 * This interface defines methods for registering customers, validating users, and retrieving customer details.
 */

public interface FlipFitCustomerDAOInterface {
    /**
     * Registers a new customer with the provided details.
     * @param name Username of the customer
     * @param password Password of the customer
     * @param email Email of the customer
     * @param phoneNumber Phone number of the customer
     * @param govId Card number of the
     * @throws RegistrationFailedException If registration fails for any reason
     */

    void registerCustomer(String name, String email, String password, String phoneNumber,String govId)throws RegistrationFailedException;

    /**
     * Checks if a user with the given username and password is valid.
     * @param name Username of the user
     * @param password Password of the user
     * @return True if the user is valid, false otherwise
     * @throws UserInvalidException If user validation fails
     */

    boolean isUserValid(String name, String password)throws UserInvalidException;

    /**
     * Retrieves details of a customer based on their username.
     * @param name Username of the customer
     * @return The FlipFitCustomer object
     */

    FlipFitCustomer getCustomerByName(String name);
}