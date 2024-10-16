package com.flipfit.dao;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitSchedule;
import com.flipfit.bean.Person;
import com.flipfit.constant.SQLConstants;
import com.flipfit.helper.DatabaseConnection;
import com.flipfit.helper.UserPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;


public class FlipFitBookingDAO implements FlipFitBookingDAOInterface {
    private final List<FlipFitBooking> bookingList = new ArrayList<>();
    private static final FlipFitScheduleDAO flipFitScheduleDAO = new FlipFitScheduleDAO();
    private static final FlipFitBookingDAO flipFitBookingDAO = new FlipFitBookingDAO();
    private static final FlipFitCustomerDAO flipFitCustomerDAO = new FlipFitCustomerDAO();

    public void addBooking(String name, String scheduleId) {
        try {
            Person person = flipFitCustomerDAO.getPersonByName(name);
            String bookingId = UUID.randomUUID().toString();
            FlipFitBooking booking = new FlipFitBooking(bookingId, name, scheduleId);
            bookingList.add(booking);
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_BOOKING);
            ps.setString(1, bookingId);
            ps.setString(2, person.getId());
            ps.setString(3, scheduleId);
            ps.executeUpdate();
            System.out.println("Booking added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FlipFitBooking> getBookingsListByCustomerId(String customerId) {
        List<FlipFitBooking> bookings = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_BOOKINGS_BY_CUSTOMER_ID);
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bookings.add(new FlipFitBooking(rs.getString("bookingId"), rs.getString("customerId"), rs.getString("scheduleId")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bookings;
    }

    public List<UserPlan> getCustomerPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        try {
            List<FlipFitBooking> customerBookings = getBookingsListByCustomerId(customerId);
            for (FlipFitBooking booking : customerBookings) {
                FlipFitSchedule schedule = flipFitScheduleDAO.getScheduleById(booking.getScheduleId());
                UserPlan userPlan = new UserPlan(
                        schedule.getSlotId(),
                        schedule.getSlotId(),
                        Instant.ofEpochMilli(schedule.getDate().getTime())
                                .atZone(ZoneId.systemDefault())
                                .toLocalTime(),
                        schedule.getScheduleId(),
                        Instant.ofEpochMilli(schedule.getDate().getTime())
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                );
                allUserPlan.add(userPlan);
            }
        } catch (Exception e) {
            System.out.println("Failed to get customer plan");
        }
        return allUserPlan;
    }

    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime) {
        LocalTime endTime = localTime.plusHours(1);
        List<UserPlan> allUserPlan = getCustomerPlan(customerId);

        // Use stream to iterate over allUserPlan and check for overlap
        return allUserPlan.stream()
                .filter(userPlan -> userPlan.getDate().equals(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                .anyMatch(userPlan -> {
                    LocalTime bookedStartTime = userPlan.getTime();
                    LocalTime bookedEndTime = bookedStartTime.plusHours(1);
                    return localTime.isBefore(bookedEndTime) && endTime.isAfter(bookedStartTime);
                });
    }

    public void cancelBookingById(String bookingID) {
        Optional<FlipFitBooking> bookingToRemove = bookingList.stream()
                .filter(booking -> booking.getBookingId().equals(bookingID))
                .findFirst();

        if (bookingToRemove.isPresent()) {
            bookingList.remove(bookingToRemove.get());
            try {
                Connection conn = DatabaseConnection.connect();
                PreparedStatement ps = conn.prepareStatement(SQLConstants.CANCEL_BOOKING_BY_ID);
                ps.setString(1, bookingID);
                ps.executeUpdate();
                System.out.println("Booking cancelled successfully");
            } catch (Exception e) {
                System.out.println("Failed to cancel");
            }
        } else {
            System.out.println("Could not cancel booking for BookingId: " + bookingID);
        }


    }

    public FlipFitBooking getBookingByBookingId(String bookingId) {
        Optional<FlipFitBooking> optionalBooking = bookingList.stream()
                .filter(booking -> booking.getBookingId().equals(bookingId))
                .findFirst();

        if (optionalBooking.isPresent()) {
            return optionalBooking.get();
        } else {
            System.out.println("Could not fetch booking by bookingId: " + bookingId);
            return null;
        }
    }
}
