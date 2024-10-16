package com.flipfit.bean;


import javax.validation.constraints.NotBlank;

/**
 * Represents a customer in the FlipFit system
 * This class extends {@link Person} and contains customer-specific details such as phone number and government id.
 *
 * @author Arvind Yadav
 */
public class FlipFitCustomer extends Person {
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String govId;

    /**
     * Parameterized constructor to initialize customer details.
     *
     * @param id          The unique id of the customer
     * @param name        The name of the customer
     * @param email       The email of the customer
     * @param password    The password of the customer
     * @param phoneNumber The phone number of the customer
     * @param govId       The unique government id of the customer
     * @author Arvind Yadav
     */
    public FlipFitCustomer(String id, String name, String email, String password, String phoneNumber, String govId) {
        super(id, name, email, password, FlipFitRole.CUSTOMER);
        this.phoneNumber = phoneNumber;
        this.govId = govId;
    }

    /**
     * Returns the phone number of the customer.
     *
     * @return Customer's phone number
     * @author Arvind Yadav
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phoneNumber Customer's phone number
     * @author Arvind Yadav
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * returns the government id of the customer
     *
     * @return Customer's government id
     * @author Arvind Yadav
     */
    public String getGovId() {
        return this.govId;
    }

    /**
     * sets the government id of the customer
     *
     * @param govId Customer's government id
     * @author Arvind Yadav
     */
    public void setGovId(String govId) {
        this.govId = govId;
    }
}
