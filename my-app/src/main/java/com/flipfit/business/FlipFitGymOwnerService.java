package com.flipfit.business;

import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.dao.FlipFitGymOwnerDAO;

import java.util.List;
import java.util.UUID;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    private static final FlipFitGymOwnerDAO flipFitGymOwnerDAO = new FlipFitGymOwnerDAO();

    public List<FlipFitGymOwner> getAllGymOwners() {
        return flipFitGymOwnerDAO.getGymOwnerList();
    }

    public FlipFitGymOwner loginGymOwner(String username,String password){
        return flipFitGymOwnerDAO.loginGymOwner(username,password);
    }

    public void registerGymOwner(String userName, String password, String email, String govId) {
        flipFitGymOwnerDAO.registerGymOwner(new FlipFitGymOwner(UUID.randomUUID().toString(), userName,email,password, govId));
    }

    public FlipFitGymOwner getGymOwnerByOwnerId(String ownerId) {
        return flipFitGymOwnerDAO.getGymOwnerByOwnerId(ownerId);
    }
}
