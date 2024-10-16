package com.flipfit.bean;

import javax.validation.constraints.NotBlank;

/**
 * Represents a gym owner in the FlipFit system
 * This class extends {@link Person} and contains owner-specific details such as government ID
 *
 * @author Arvind Yadav
 */
public class FlipFitGymOwner extends Person {
    @NotBlank
    private String govId;

    /**
     * Parameterized constructor to initialize gym owner details.
     *
     * @param id       ID of the gym owner
     * @param name     Username of the gym owner
     * @param email    Email of the gym owner
     * @param password Password of the gym owner
     * @param govId    Government ID of the gym owner
     * @author Arvind Yadav
     */
    public FlipFitGymOwner(String id, String name, String email, String password, String govId) {
        super(id, name, email, password, FlipFitRole.GYM_OWNER);
        this.govId = govId;
    }

    /**
     * Returns the government ID of the gym owner
     *
     * @return govId of the gym owner
     * @author Arvind Yadav
     */
    public String getGovId() {
        return this.govId;
    }

    /**
     * Sets the government ID of the gym owner
     *
     * @param govId Government ID of the gym owner
     * @author Arvind Yadav
     */
    public void SetGovId(String govId) {
        this.govId = govId;
    }
}
