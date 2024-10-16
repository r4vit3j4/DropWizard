package com.flipfit.bean;

import javax.validation.constraints.NotBlank;

/**
 * Represents a booking in the FlipFit system.
 * A booking links a user to a specific schedule.
 *
 * @author Arvind Yadav
 */
public class FlipFitBooking {
    @NotBlank
    private String bookingId;
    @NotBlank
    private String customerId;
    @NotBlank
    private String scheduleId;

    /**
     * Parameterized constructor to create a new booking.
     *
     * @param customerId ID of the customer making the booking
     * @param scheduleId ID of the schedule being booked
     * @author Arvind Yadav
     */
    public FlipFitBooking(String customerId, String scheduleId) {
        this.customerId = customerId;
        this.scheduleId = scheduleId;
    }

    /**
     * Parameterized constructor to create a booking with existing id.
     *
     * @param bookingId  ID of the booking
     * @param customerId ID of the customer associated with the booking.
     * @param scheduleId ID of the schedule being booked
     * @author Arvind Yadav
     */
    public FlipFitBooking(String bookingId, String customerId, String scheduleId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.scheduleId = scheduleId;
    }

    /**
     * Returns the booking ID
     *
     * @return bookingId
     * @author Arvind Yadav
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Returns the customer ID
     *
     * @return customerId
     * @author Arvind Yadav
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Returns the schedule ID
     *
     * @return scheduleId
     * @author Arvind Yadav
     */
    public String getScheduleId() {
        return scheduleId;
    }


    /**
     * Sets the booking ID.
     *
     * @param bookingId ID of the booking
     * @author Arvind Yadav
     */

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Sets the customer ID associated with the booking.
     *
     * @param customerId ID of the customer associated with the booking.
     * @author Arvind Yadav
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Sets the schedule ID associated with the booking.
     *
     * @param scheduleId ID of the schedule associated with the booking.
     * @author Arvind Yadav
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}
