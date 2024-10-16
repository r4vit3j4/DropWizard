package com.flipfit.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;


/**
 * Represents a slot of a FlipFit system
 * @author Arvind Yadav
 */
public class FlipFitSlot {
    private String slotId;
    private String gymCenterId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime slotTime;

    /**
     * Constructor to create the FlipFitSlot
     * @param slotId is the slot id
     * @param gymCenterId is gymCenterId
     * @param slotTime is slotTime
     *                 @author Arvind Yadav
     */
    public FlipFitSlot() {}

    public FlipFitSlot(String slotId, String gymCenterId, LocalTime slotTime) {
        this.slotId = slotId;
        this.gymCenterId = gymCenterId;
        this.slotTime = slotTime;
    }

    /**
     * Returns the slot ID
     * @return slotId The slot Id
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Returns the gym center ID
     * @return gymCenterId
     */
    public String getGymCenterId() {
        return gymCenterId;
    }

    /**
     *Returns the slot time
     * @return slotTime
     */
    public LocalTime getSlotTime() {
        return slotTime;
    }

    /**
     *
     * @param slotId
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     *
     * @param gymCenterId
     */
    public void setGymCenterId(String gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    /**
     *
     * @param slotTime
     */
    public void setSlotTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }
}
