package com.flipfit.dao;

import com.flipfit.bean.Person;

public interface FlipFitUserDAOInterface {
    Person authenticate(String username, String password);

    void register(String name, String email, String password, String phoneNumber, String govId, int role_id);

    boolean checkIfUserExists(String username, String password);
}
