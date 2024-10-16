package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.dao.FlipFitBookingDAO;
import com.flipfit.exceptions.BookingFailedException;
import com.flipfit.helper.UserPlan;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class FlipFitBookingService implements FlipFitBookingInterface {

    private final FlipFitBookingDAO bookingDAO = new FlipFitBookingDAO();
    private final FlipFitScheduleService scheduleService  = new FlipFitScheduleService();
    private final FlipFitSlotService slotService = new FlipFitSlotService();

    public void addBooking(String userName, String scheduleID) {
        try {
            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
            if(!isAvailable){
                System.out.println("No seats available for the booking");
                return;
            }
            bookingDAO.addBooking(userName, scheduleID);
        } catch (BookingFailedException e) {
            System.out.println("Failed to add booking");

        }
    }

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        FlipFitSlot slot = slotService.getSlotById(slotId);
        System.out.println(slot.toString());
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getSlotTime());
    }

    public List<FlipFitBooking> getBookingListByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingsListByCustomerId(customerId);
        } catch (BookingFailedException e) {
            System.out.println("Failed to get booking");
        }
        return null;
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    public void cancelBooking(String bookingID) {
        try {
            FlipFitBooking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleId(),1);
        } catch (BookingFailedException e) {
            System.out.println("Failed to cancel booking");
        }
    }
}
