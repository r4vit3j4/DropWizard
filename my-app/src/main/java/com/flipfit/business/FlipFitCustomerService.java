package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.dao.FlipFitCustomerDAO;
import com.flipfit.exceptions.RegistrationFailedException;
import com.flipfit.exceptions.UserInvalidException;
import com.flipfit.helper.UserPlan;

import java.util.Date;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    private FlipFitGymCenterInterface gymCenterService = new FlipFitGymCenterService();
    private FlipFitBookingInterface bookingService = new FlipFitBookingService();
    private FlipFitScheduleInterface scheduleService = new FlipFitScheduleService();
    private FlipFitSlotInterface slotService = new FlipFitSlotService();
    private FlipFitCustomerDAO customerDAO = new FlipFitCustomerDAO();

    public void registerCustomer(String username, String email, String password, String phoneNumber,String govId) {
        try {
            customerDAO.registerCustomer(username,password,email,phoneNumber,govId);
        } catch (RegistrationFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FlipFitGymCenter> getGymCentersListByCity(String city) {
        return gymCenterService.getGymCentersByCity(city);
    }

    public List<FlipFitSlot> getAvailableSlots(String centerId, Date date) {
        System.out.println(3);
        return gymCenterService.getAvailableSlotsByCenterAndDate(centerId, date);
    }

    public List<FlipFitBooking> getCustomerBookings(String customerId) {
        return bookingService.getBookingListByCustomerId(customerId);
    }

    public boolean bookSlot(String username, Date date, String slotId, String centerId) {
        if(!slotService.isSlotValid(slotId,centerId)){
            System.out.println("INVALID SLOT");
            return false;
        }

        String scheduleId = scheduleService.getOrCreateSchedule(slotId, date).getScheduleId();

//        System.out.println("SCHEDULE ID: " + scheduleId);
        //create booking

        boolean isOverlap = bookingService.checkBookingOverlap(username,date,slotId);

        if(isOverlap) {
            System.out.println("There exists a conflicting booking, First cancel it!!!!");
            return false;
        }
        bookingService.addBooking(username, scheduleId);
        return true;
    }

    public void cancelBookingById(String bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    public FlipFitCustomer viewMyProfile(String username) {
        return customerDAO.getCustomerByName(username);
    }

    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingService.getCustomerPlan(customerId);
    }
}
