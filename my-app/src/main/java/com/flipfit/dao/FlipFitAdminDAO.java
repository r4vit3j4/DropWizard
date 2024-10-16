package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymCenter;

import java.util.List;

public class FlipFitAdminDAO implements FlipFitAdminDAOInterface {
    private static final FlipFitGymCenterDAO gymCenterDAO = new FlipFitGymCenterDAO();

    public List<FlipFitGymCenter> getPendingGymCentersList() {
        return gymCenterDAO.getPendingGymCentersList();
    }

    public void validateGymCenter(String gymCenterId, boolean isApproved) {
        gymCenterDAO.validateGymCenter(gymCenterId, isApproved);
    }

    public List<FlipFitGymCenter> getAllGymCentersList() {
        return gymCenterDAO.getAllGymCenters();
    }

    public void removeGymCenter(String gymCenterId) {
        gymCenterDAO.removeGymCenter(gymCenterId);
    }
}
