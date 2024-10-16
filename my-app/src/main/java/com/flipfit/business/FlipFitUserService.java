package com.flipfit.business;

import com.flipfit.bean.Person;
import com.flipfit.dao.FlipFitUserDAO;

public class FlipFitUserService implements FlipFitUserInterface {
    private static final FlipFitUserDAO userDAO = new FlipFitUserDAO();

    public Person authenticate(String username, String password) {
        return userDAO.authenticate(username, password);
    }

    public boolean checkIfUserExists(String username, String password) {
        return userDAO.checkIfUserExists(username, password);
    }

    public void register(String name, String email, String password, String phoneNumber, String govId, int role_id){
        userDAO.register(name, email, password, phoneNumber, govId, role_id);
    }
}
