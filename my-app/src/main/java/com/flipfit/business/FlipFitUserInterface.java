package com.flipfit.business;

import com.flipfit.bean.Person;

public interface FlipFitUserInterface {
    Person authenticate(String username, String password);

    boolean checkIfUserExists(String username, String password);
//    void register(String username, String password);

    void register(String name, String email, String password, String phoneNumber, String govId, int role_id);
}
