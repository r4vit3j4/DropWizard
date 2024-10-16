package com.flipfit.constant;

public class SQLConstants {

//    person
    public static final String ADD_NEW_PERSON = "INSERT INTO FlipFit.Persons (id, name, email, password, role_id) VALUES (?, ?, ?, ?, ?)";

//    Customer
    public static final String CUSTOMER_LOGIN_QUERY = "SELECT * FROM FlipFit.Persons WHERE name=? AND password=?;";
    public static final String ADD_NEW_CUSTOMER = "INSERT INTO FlipFit.FlipFitCustomers (person_id, phoneNumber,govId) VALUES (?, ?,?);";
    public static final String GET_CUSTOMER_BY_NAME = "SELECT * FROM FlipFit.FlipFitCustomers WHERE name=?;";
    public static final String GET_PERSON_BY_NAME = "SELECT * FROM FlipFit.Persons WHERE name=?;";
    public static final String GET_PERSON_BY_ID = "SELECT * FROM FlipFit.Persons WHERE id=?;";

//    Gym Owner
    public static final String REGISTER_GYM_OWNER = "INSERT INTO FlipFit.FlipFitGymOwners (person_id, govId) VALUES (?, ?);";
    public static final String LOGIN_GYM_OWNER = "SELECT * FROM FlipFit.Persons WHERE name=? and password=?;";
    public static final String GET_ALL_GYM_OWNERS_QUERY = "SELECT * FROM FlipFit.FlipFitGymOwners";
    public static final String GET_GYM_OWNER_BY_ID = "SELECT * FROM FlipFit.Persons WHERE id=?;";

    //    Gym Center
    public static final String ADD_GYM_CENTER_QUERY = "INSERT INTO FlipFit.FlipFitGymCenters (gymCenterId, gymOwnerId, gymCenterName, city, capacity, price, isApproved) VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String GET_ALL_GYM_CENTERS = "SELECT * FROM FlipFit.FlipFitGymCenters";
    public static final String GET_GYM_CENTERS_BY_OWNER_ID = "SELECT * FROM FlipFit.FlipFitGymCenters WHERE gymOwnerId=?;";
    public static final String GET_ALL_PENDING_GYM_CENTERS = "SELECT * FROM FlipFit.FlipFitGymCenters WHERE isApproved = 0;";
    public static final String APPROVE_GYM_CENTER_BY_ID = "UPDATE FlipFit.FlipFitGymCenters SET isApproved=? WHERE gymCenterId=?;";
    public static final String GET_GYM_CENTERS_BY_CITY = "SELECT * FROM FlipFit.FlipFitGymCenters WHERE city=?;";
    public static final String GET_GYM_CENTER_BY_ID = "SELECT * FROM FlipFit.FlipFitGymCenters WHERE gymCenterId=?;";
    public static final String REMOVE_GYM_CENTER_BY_ID = "DELETE FROM FlipFit.FlipFitGymCenters WHERE gymCenterId=?;";

    //    Booking
    public static final String GET_BOOKINGS_BY_CUSTOMER_ID = "SELECT * FROM FlipFit.FlipFitBookings WHERE customerId=?;";
    public static final String CANCEL_BOOKING_BY_ID = "DELETE FROM FlipFit.FlipFitBookings WHERE bookingId=?;";
    public static final String ADD_BOOKING = "INSERT INTO FlipFit.FlipFitBookings (bookingId, customerId, scheduleId) VALUES (?, ?, ?);";
    public static final String GET_BOOKING_BY_ID = "SELECT * FROM FlipFit.FlipFitBookings WHERE bookingId=?;";

//    Schedule
    public static final String ADD_SCHEDULE = "INSERT INTO FlipFit.FlipFitSchedules (scheduleId, slotId, availability, date) VALUES (?, ?, ?, ?);";
    public static final String GET_SCHEDULES_BY_ID = "SELECT * FROM FlipFit.FlipFitSchedules WHERE scheduleId=?;";
    public static final String GET_SCHEDULES_BY_DATE = "SELECT * FROM FlipFit.FlipFitSchedules WHERE date=?;";
    public static final String MODIFY_SCHEDULE_AVAILABILTY = "UPDATE FlipFit.FlipFitSchedules SET availability=? WHERE scheduleId=?;";

//    Slot
    public static final String GET_ALL_SLOTS = "SELECT * FROM FlipFit.FlipFitSlots";
    public static final String GET_SLOTS_BY_GYM_CENTER = "SELECT * FROM FlipFit.FlipFitSlots WHERE gymCenterId=?;";
    public static final String ADD_SLOT = "INSERT INTO FlipFit.FlipFitSlots (slotId, gymCenterId, slotTime) VALUES (?, ?, ?);";
    public static final String GET_SLOT_BY_ID = "SELECT * FROM FlipFit.FlipFitSlots WHERE slotId=?;";
    public static final String GET_SLOT_BY_ID_AND_GYM_CENTER_ID = "SELECT * FROM FlipFit.FlipFitSlots WHERE slotId=? AND gymCenterId=?;";
}
