package com.flipfit.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;


/**
 * Represents Schedule of any slot of a gym center
 *
 * @author Arvind Yadav
 */
public class FlipFitSchedule {
    @NotBlank
    private String scheduleId;
    @NotBlank
    private String slotId;
    @NotBlank
    private int availability;
    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    /**
     * Constructor for FlipFitSchedule.
     *
     * @param date         Date of the schedule
     * @param slotId       Slot ID of the schedule
     * @param availability Availability in a slot
     * @author Arvind Yadav
     */
    public FlipFitSchedule(Date date, String slotId, int availability) {
        this.scheduleId = UUID.randomUUID().toString();
        this.date = date;
        this.slotId = slotId;
        this.availability = availability;
    }

    /**
     * Returns the Schedule ID
     *
     * @return scheduleId
     * @author Pratik Singh
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * Returns the slot ID
     *
     * @return slotId
     * @author Pratik Singh
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Returns the availability
     *
     * @return availability
     * @author Pratik Singh
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Returns the date
     *
     * @return date
     * @author Pratik Singh
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the schedule ID
     *
     * @param scheduleId ID of the schedule
     * @author Pratik Singh
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * Sets the slot ID
     *
     * @param slotId ID of the schedule
     * @author Pratik Singh
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Sets the availability
     *
     * @param availability Availability of the schedule
     * @author Pratik Singh
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Sets the date
     *
     * @param date date of the schedule
     * @author Pratik Singh
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
