package com.flipfit.bean;

import javax.validation.constraints.NotBlank;

/**
 * Represents a payment in the FlipFit system.
 * Each payment is associated with a booking and contains details such as payment ID and amount paid.
 *
 * @author Arvind Yadav
 */
public class FlipFitPayment {
    @NotBlank
    private String paymentId;
    @NotBlank
    private String amountPaid;
    @NotBlank
    private String bookingId;
    @NotBlank
    FlipFitPaymentMode paymentMode;

    /**
     * Retrieves the payment ID.
     *
     * @return Payment ID
     * @author Arvind Yadav
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Returns the amount paid.
     *
     * @return amount paid
     * @author Arvind Yadav
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Returns the booking ID
     *
     * @return Booking ID
     * @author Arvind Yadav
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Returns the mode of payment done
     *
     * @return Mode of payment
     * @author Arvind Yadav
     */
    public FlipFitPaymentMode getPaymentMode() {
        return paymentMode;
    }

    /**
     * Sets the payment ID
     *
     * @param paymentId ID of the payment
     * @author Arvind Yadav
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Sets the amount paid
     *
     * @param amountPaid Amount paid
     * @author Arvind Yadav
     */
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Sets the booking ID
     *
     * @param bookingId ID of the booking
     * @author Arvind Yadav
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Sets the mode of payment
     *
     * @param paymentMode Mode of payment
     * @author Arvind Yadav
     */
    public void setPaymentMode(FlipFitPaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
