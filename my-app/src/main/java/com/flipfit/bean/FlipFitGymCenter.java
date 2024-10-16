package com.flipfit.bean;

import javax.validation.constraints.NotBlank;

/**
 * Represents a gym center in the FlipFit system.
 *
 * @author Arvind Yadav
 */
public class FlipFitGymCenter {
    private String gymCenterId;
    @NotBlank
    private String gymCenterName;
    @NotBlank
    private String gymOwnerId;
    @NotBlank
    private String city;
    @NotBlank
    private int capacity;
    @NotBlank
    private int price;
    private boolean isApproved;

    public FlipFitGymCenter() {}

    /**
     * Parameterized constructor to initialize gym center details.
     * The approval status is set to "false" by default
     *
     * @param gymCenterId   ID of the gym center
     * @param gymOwnerId    ID of the owner of the gym center
     * @param gymCenterName Name of the gym center
     * @param city          City where the gym center is located
     * @param capacity      Maximum capacity of the gym center
     * @param price         Price associated with the gym center
     * @author Arvind Yadav
     */
    public FlipFitGymCenter(String gymCenterId, String gymCenterName, String gymOwnerId, String city, int capacity, int price) {
        this.gymCenterId = gymCenterId;
        this.gymCenterName = gymCenterName;
        this.gymOwnerId = gymOwnerId;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = false;
    }


    /**
     * Parameterized constructor to initialize gym center details, including approval status.
     *
     * @param gymCenterId   ID of the gym center
     * @param gymOwnerId    ID of the owner of the gym center
     * @param gymCenterName Name of the gym center
     * @param city          City where the gym center is located
     * @param capacity      Maximum capacity of the gym center
     * @param price         Price associated with the gym center
     * @param isApproved    Approval status of the gym center
     * @author Arvind Yadav
     */
    public FlipFitGymCenter(String gymCenterId, String gymCenterName, String gymOwnerId, String city, int capacity, int price, boolean isApproved) {
        this.gymCenterId = gymCenterId;
        this.gymCenterName = gymCenterName;
        this.gymOwnerId = gymOwnerId;
        this.city = city;
        this.capacity = capacity;
        this.price = price;
        this.isApproved = isApproved;
    }

    /**
     * Returns the ID of the gym center.
     *
     * @return ID of the gym center
     * @author Arvind Yadav
     */
    public String getGymCenterId() {
        return this.gymCenterId;
    }

    /**
     * Returns the name of the gym center.
     *
     * @return Name of the gym center
     * @author Arvind Yadav
     */
    public String getGymCenterName() {
        return this.gymCenterName;
    }

    /**
     * Returns the ID of the owner of the gym center.
     *
     * @return Owner ID of the gym center
     * @author Arvind Yadav
     */
    public String getGymOwnerId() {
        return this.gymOwnerId;
    }

    /**
     * Returns the city where the gym center is located.
     *
     * @return City of the gym center
     * @author Arvind Yadav
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Returns the maximum capacity of the gym center.
     *
     * @return capacity
     * @author Arvind Yadav
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returns the price associated with the gym center.
     *
     * @return price
     * @author Arvind Yadav
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns the approval status of the gym center.
     *
     * @return True/False
     * @author Arvind Yadav
     */
    public boolean isApproved() {
        return this.isApproved;
    }

    /**
     * Sets the ID of the gym center.
     *
     * @param gymCenterId the ID of the gym center.
     * @author Arvind Yadav
     */
    public void setGymCenterId(String gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    /**
     * Sets the name of the gym center.
     *
     * @param gymCenterName the name of the gym center.
     * @author Arvind Yadav
     */
    public void setGymCenterName(String gymCenterName) {
        this.gymCenterName = gymCenterName;
    }

    /**
     * Sets the ID of the gym owner.
     *
     * @param gymOwnerId the ID of the gym owner.
     * @author Arvind Yadav
     */
    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    /**
     * Sets the city where the gym center is located
     *
     * @param city city where the gym center is located
     * @author Arvind Yadav
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the maximum capacity of the gym center
     *
     * @param capacity maximum capacity of the gym center
     * @author Arvind Yadav
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Sets the price associated with the gym center
     *
     * @param price price associated with the gym center
     * @author Arvind Yadav
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the approval status of the gym center.
     *
     * @param isApproved approval status of the gym center
     * @author Arvind Yadav
     */
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
}
