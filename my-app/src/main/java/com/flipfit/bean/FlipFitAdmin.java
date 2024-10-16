package com.flipfit.bean;

/**
 * Represents an admin user in the FlipFit system.
 * This class extends {@link Person} and provides a constructor for initializing admin details
 *
 * @author Arvind Yadav
 */
public class FlipFitAdmin extends Person {
    /**
     * Default constructor for creating an admin user.
     *
     * @param id       the unique id of the admin
     * @param name     the name of the admin
     * @param email    the email of the admin
     * @param password the password of the admin
     * @author Arvind Yadav
     */

    public FlipFitAdmin(String id, String name, String email, String password) {
        super(id, name, email, password, FlipFitRole.ADMIN);
    }
}
