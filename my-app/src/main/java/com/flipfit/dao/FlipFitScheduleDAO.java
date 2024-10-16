package com.flipfit.dao;

import com.flipfit.bean.FlipFitSchedule;
import com.flipfit.constant.SQLConstants;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlipFitScheduleDAO implements FlipFitScheduleDAOInterface {

    public void addSchedule(FlipFitSchedule schedule) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SCHEDULE);
            ps.setString(1, schedule.getScheduleId());
            ps.setString(2, schedule.getSlotId());
            ps.setInt(3, schedule.getAvailability());
            Date date = schedule.getDate();
            ps.setDate(4, new java.sql.Date(date.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FlipFitSchedule getScheduleById(String scheduleId) {
        FlipFitSchedule schedule = null;
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_ID);
            ps.setString(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                Date date = rs.getDate("date");
                schedule = new FlipFitSchedule(date, slotId, availability);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schedule;
    }

    public List<FlipFitSchedule> getScheduleListByDate(Date date) {
        ArrayList<FlipFitSchedule> schedules = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_DATE);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            System.out.println(date.toString());
            while(rs.next()) {
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                String scheduleId = rs.getString("scheduleId");
                FlipFitSchedule schedule = new FlipFitSchedule(date, slotId, availability);
                schedule.setScheduleId(scheduleId);
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return schedules;
    }

    public boolean modifySchedule(String scheduleId, int action) {
        try {
            FlipFitSchedule schedule = getScheduleById(scheduleId);
            int availability = 0;

            if (schedule!=null) {
                availability = schedule.getAvailability();
            }

            if(availability < 1 && action == -1) {
                return false;
            }
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.MODIFY_SCHEDULE_AVAILABILTY);
            ps.setInt(1, availability+action);
            ps.setString(2, scheduleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
