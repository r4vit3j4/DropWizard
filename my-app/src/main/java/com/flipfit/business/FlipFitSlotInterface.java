package com.flipfit.business;

import com.flipfit.bean.FlipFitSlot;

import java.util.List;

/**
 * Interface defining operations related to slots in the FlipFit system.
 */
public interface FlipFitSlotInterface {

    /**
     * Retrieves all slots associated with a specific gym center.
     * @param centerId ID of the gym center
     * @return List of slots for the gym center
     */
    List<FlipFitSlot> getAllSlotsByGymCenter(String centerId);


    /**
     * Retrieves a slot based on its ID.
     * @param slotID ID of the slot
     * @return The FlipFitSlot object
     */
    FlipFitSlot getSlotById(String slotID);

    /**
     * Retrieves a list of all slots.
     * @return List of all slots
     */
    List<FlipFitSlot> getSlotList();

    /**
     * Adds slots to a gym center identified by its ID.
     * @param gymCenterId ID of the gym center
     * @param slotList List of slots to add
     */
    void addSlotsForGym(String gymCenterId, List<FlipFitSlot> slotList);

    /**
     * Adds slots to a gym center identified by its ID.
     * @param gymCenterId ID of the gym center
     * @param newSlot slot to add
     */
    void addSlotForGym(String gymCenterId, FlipFitSlot newSlot);

    /**
     * Checks if a slot is valid for a specific gym center.
     * @param slotId ID of the slot
     * @param centerId ID of the gym center
     * @return True if the slot is valid, false otherwise
     */
    boolean isSlotValid(String slotId, String centerId);



    /**
     * Retrieves a slot based on its ID and gym center ID.
     * @param slotID ID of the slot
     * @param centerId ID of the gym center
     * @return The FlipFitSlot object
     */
    FlipFitSlot getSlotByIdAndGymCenterId(String slotID, String centerId);
}

