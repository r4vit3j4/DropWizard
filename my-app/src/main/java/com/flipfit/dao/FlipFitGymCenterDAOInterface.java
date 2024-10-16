package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymCenter;

import java.util.List;

/**
 * Data Access Object (DAO) interface for handling gym center-related operations in FlipFit system.
 * This interface defines methods for viewing, adding, retrieving gym centers,
 * managing approval requests, and fetching gym centers by specific criteria.
 */

public interface FlipFitGymCenterDAOInterface {
    /**
     * Retrieves details of all gym centers.
     * @return List of all gym centers
     */
    List<FlipFitGymCenter> getAllGymCenters();


    /**
     * Retrieves details of all gym centers owned by a specific owner.
     * @param gymOwnerId ID of the gym owner
     * @return List of gym centers owned by the specified owner
     */

    List<FlipFitGymCenter> getAllGymCentersByOwnerId(String gymOwnerId);

    /**
     * Retrieves details of a gym center based on its ID.
     * @param gymCenterId ID of the gym center
     * @return The FlipFitGymCenter object
     */

    FlipFitGymCenter getGymCenterById(String gymCenterId);

    /**
     * Adds a new gym center to the system.
     * @param gymCenter The FlipFitGymCenter object representing the gym center to add
     */
    void addGymCenter(FlipFitGymCenter gymCenter);

    /**
     * Retrieves a list of pending gym centers awaiting approval.
     * @return List of pending gym centers
     */

    List<FlipFitGymCenter> getPendingGymCentersList();

    /**
     * Validates (approves or rejects) a gym center based on its ID.
     * @param gymCenterId ID of the gym center to validate
     * @param isApproved True to approve, false to reject
     */
    void validateGymCenter(String gymCenterId, boolean isApproved);

    /**
     * Sends a request for approval of a gym center based on its ID.
     * @param gymCenterId ID of the gym center to request approval for
     */
    void sendGymCenterApprovalRequest(String gymCenterId);

    /**
     * Retrieves a list of gym centers located in a specific city.
     * @param city City name
     * @return List of gym centers in the specified city
     */

    List<FlipFitGymCenter> getGymCentersListByCity(String city);
}
