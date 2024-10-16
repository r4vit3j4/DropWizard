package com.flipfit.business;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;

import java.util.Date;
import java.util.List;

/**
 * Interface defining operations related to gym centers in the FlipFit system.
 */

public interface FlipFitGymCenterInterface {

    /**
     * Interface defining operations related to gym centers in the FlipFit system.
     */
    List<FlipFitGymCenter> getAllGymCenters();

    /**
     * Retrieves details of all gym centers owned by a specific gym owner.
     * @param gymOwnerId ID of the gym owner
     * @return List of gym centers owned by the gym owner
     */
    List<FlipFitGymCenter> getGymCentersByOwnerId(String gymOwnerId);


    /**
     * Retrieves details of gym centers located in a specific city.
     * @param city City name
     * @return List of gym centers in the specified city
     */
    List<FlipFitGymCenter> getGymCentersByCity(String city);

    /**
     * Retrieves available slots for booking at a specific gym center on a given date.
     * @param centerId ID of the gym center
     * @param date Date for which slots are to be retrieved
     * @return List of available slots
     */
    List<FlipFitSlot> getAvailableSlotsByCenterAndDate(String centerId, Date date);


    /**
     * Adds a new gym center to the system.
     * @param gymCenter Gym center object to add
     */
    void addCenter(FlipFitGymCenter gymCenter);

    /**
     * Requests approval for a gym center identified by its ID.
     * @param gymCenterId ID of the gym center to request approval for
     */
    void requestGymCenterApproval(String gymCenterId);

    /**
     * Retrieves details of a gym center identified by its ID.
     * @param gymCenterId ID of the gym center
     * @return Gym center object
     */
    FlipFitGymCenter getGymCenterById(String gymCenterId);
}
