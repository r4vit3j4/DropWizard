package com.flipfit.dao;

import com.flipfit.bean.FlipFitSlot;
import com.flipfit.constant.SQLConstants;
import com.flipfit.helper.DatabaseConnection;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotDAO implements FlipFitSlotDAOInterface{

    public List<FlipFitSlot> getSlotList() {
        List<FlipFitSlot> slotList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_ALL_SLOTS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String slotId = rs.getString("slotId");
                String gymCenterId = rs.getString("gymCenterId");
                LocalTime slotTime = rs.getTime("slotTime").toLocalTime();

                slotList.add(new FlipFitSlot(slotId, gymCenterId, slotTime));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return slotList;
    }

    public List<FlipFitSlot> getSlotListByCenterId(String centerId) {
        System.out.println(7);
        List<FlipFitSlot> slotList = new ArrayList<>();
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SLOTS_BY_GYM_CENTER);
            ps.setString(1, centerId);
            ResultSet rs = ps.executeQuery();
            System.out.println(8);

            while (rs.next()) {
                String slotId = rs.getString("slotId");
                String gymCenterId = rs.getString("gymCenterId");
                LocalTime slotTime = rs.getTime("slotTime").toLocalTime();

                slotList.add(new FlipFitSlot(slotId, gymCenterId, slotTime));

            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return slotList;
    }

    public void addSlot(FlipFitSlot slot) {
        try {
            Connection con = DatabaseConnection.connect();
            PreparedStatement ps = con.prepareStatement(SQLConstants.ADD_SLOT);
            ps.setString(1, slot.getSlotId());
            ps.setString(2, slot.getGymCenterId());
            ps.setTime(3, Time.valueOf(slot.getSlotTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public FlipFitSlot getSlotById(String slotId) {
        FlipFitSlot slot = null;
        try {
            Connection con = DatabaseConnection.connect();
            PreparedStatement ps = con.prepareStatement(SQLConstants.GET_SLOT_BY_ID);
            ps.setString(1, slotId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String gymCenterId = rs.getString("gymCenterId");
                LocalTime slotTime = rs.getTime("slotTime").toLocalTime();
                slot = new FlipFitSlot(slotId, gymCenterId, slotTime);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(slot==null){
            System.out.println("slot is null");
            return new FlipFitSlot("-1","-1",LocalTime.now());
        }
        return slot;
    }

    public FlipFitSlot getSlotByIdAndCenterId(String slotId, String centerId) {
        FlipFitSlot slot = null;
        try {
            Connection con = DatabaseConnection.connect();
            PreparedStatement ps = con.prepareStatement(SQLConstants.GET_SLOT_BY_ID_AND_GYM_CENTER_ID);
            ps.setString(1, slotId);
            ps.setString(2, centerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LocalTime slotTime = rs.getTime("slotTime").toLocalTime();
                slot = new FlipFitSlot(slotId, rs.getString("gymCenterId"), slotTime);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return slot;
    }
}
