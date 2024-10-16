package com.flipfit.business;

import com.flipfit.bean.FlipFitGymOwner;

import java.util.List;

/**
 * Interface defining operations related to gym owners in the FlipFit system.
 */
public interface FlipFitGymOwnerInterface {

    /**
     * Registers a new gym owner with the provided details.
     * @param username Username of the gym owner
     * @param password Password of the gym owner
     * @param email Email of the gym owner
     * @param govId PAN number of the gym owner
     */
    void registerGymOwner(String username, String password, String email, String govId);

    /**
     * Validates the login credentials of a gym owner.
     * @param name  of the gym owner
     * @param password Password of the gym owner
     * @return True if login is successful, false otherwise
     */
    FlipFitGymOwner loginGymOwner(String name, String password);

    /**
     * Retrieves details of all registered gym owners.
     * @return List of all gym owners
     */
    List<FlipFitGymOwner> getAllGymOwners();
}
