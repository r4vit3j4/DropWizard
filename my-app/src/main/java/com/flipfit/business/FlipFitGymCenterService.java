package com.flipfit.business;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.dao.FlipFitGymCenterDAO;

import java.util.List;

public class FlipFitGymCenterService implements FlipFitGymCenterInterface {

    private final static FlipFitGymCenterDAO flipFitGymCenterDAO = new FlipFitGymCenterDAO();
    private final static FlipFitScheduleInterface scheduleService = new FlipFitScheduleService();

    public List<FlipFitGymCenter> getAllGymCenters() {
        return flipFitGymCenterDAO.getAllGymCenters();
    }

    public List<FlipFitGymCenter> getGymCentersByOwnerId(String gymOwnerId) {
        return flipFitGymCenterDAO.getAllGymCentersByOwnerId(gymOwnerId);
    }

    public List<FlipFitGymCenter> getGymCentersByCity(String city){
        return flipFitGymCenterDAO.getGymCentersListByCity(city);
    }

    public List<FlipFitSlot> getAvailableSlotsByCenterAndDate(String centreID, java.util.Date date) {
        System.out.println(4);
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(FlipFitGymCenter gymCentre) {
        //takes gymCenter details
        flipFitGymCenterDAO.addGymCenter(gymCentre);
    }

    public void requestGymCenterApproval(String gymCentreId){
        flipFitGymCenterDAO.sendGymCenterApprovalRequest(gymCentreId);
    }

    public FlipFitGymCenter getGymCenterById(String centreID) {
        return flipFitGymCenterDAO.getGymCenterById(centreID);
    }
}
