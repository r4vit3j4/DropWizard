package com.flipfit.business;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.dao.FlipFitAdminDAO;

import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {
    FlipFitAdminDAO flipFitAdminDAO = new FlipFitAdminDAO();

    public void approveGymCenter(String gymCenterId) {
        flipFitAdminDAO.validateGymCenter(gymCenterId, true);
    }

    public void rejectGymCenter(String gymCenterId) {
        flipFitAdminDAO.validateGymCenter(gymCenterId, false);
    }

    public List<FlipFitGymCenter> getPendingGymCentersList() {
        return flipFitAdminDAO.getPendingGymCentersList();
    }

    public List<FlipFitGymCenter> getAllGymCentersList() {
        return flipFitAdminDAO.getAllGymCentersList();
    }

    public void removeGymCenter(String gymCenterId) {
        flipFitAdminDAO.removeGymCenter(gymCenterId);
    }
}
