package com.flipfit.bean;

import javax.validation.constraints.NotBlank;

/**
 * Represents a FlipFit user
 * This class contains details such as id, name, email, password, role
 *
 * @author Arvind Yadav
 */
public class Person {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private FlipFitRole role;

    /**
     * Constructs a new Person with specified details
     *
     * @param id       the unique id of the person
     * @param name     the name of the person
     * @param email    the email of the person
     * @param password the password of the person
     * @param role     the role of the person (e.g., ADMIN, CUSTOMER, GYM_OWNER)
     * @author Arvind Yadav
     */
    public Person(String id, String name, String email, String password, FlipFitRole role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    /**
     * Returns the id of the person
     *
     * @return id
     * @author Arvind Yadav
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the name of the person
     *
     * @return name
     * @author Arvind Yadav
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the email of the person
     *
     * @return email
     * @author Arvind Yadav
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns the password of the person
     *
     * @return password
     * @author Arvind Yadav
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the role of the person
     *
     * @return role
     * @author Arvind Yadav
     */
    public FlipFitRole getRole() {
        return this.role;
    }

    /**
     * Sets the id of the person
     *
     * @param id the unique id of the person
     * @author Arvind Yadav
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the person
     *
     * @param name the name of the person
     * @author Arvind Yadav
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the email of the person
     *
     * @param email the email of the person
     * @author Arvind Yadav
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the password of the person
     *
     * @param password the password of the person
     * @author Arvind Yadav
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the role of the person
     *
     * @param role the role of the password
     * @author Arvind Yadav
     */
    public void setRole(FlipFitRole role) {
        this.role = role;
    }
}
