package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.constant.SQLConstants;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCenterDAO implements FlipFitGymCenterDAOInterface {

    private Connection conn = null;
    PreparedStatement statement = null;


    public List<FlipFitGymCenter> getAllGymCenters() {
        List<FlipFitGymCenter> allGymCenters = new ArrayList<>();
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.GET_ALL_GYM_CENTERS);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitGymCenter gymCentre = new FlipFitGymCenter(
                        rs.getString("gymCenterId"),
                        rs.getString("gymOwnerId"),
                        rs.getString("gymCenterName"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getBoolean("isApproved")
                );
                gymCentre.setApproved(rs.getBoolean("isApproved"));
                allGymCenters.add(gymCentre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allGymCenters;
    }

    public List<FlipFitGymCenter> getAllGymCentersByOwnerId(String gymOwnerId) {
        List<FlipFitGymCenter> allGymCenters = new ArrayList<>();
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.GET_GYM_CENTERS_BY_OWNER_ID);
            statement.setString(1, gymOwnerId);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitGymCenter gymCentre = new FlipFitGymCenter(
                        rs.getString("gymCenterId"),
                        rs.getString("gymOwnerId"),
                        rs.getString("gymCenterName"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getBoolean("isApproved")
                );
                gymCentre.setApproved(rs.getBoolean("isApproved"));
                allGymCenters.add(gymCentre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return allGymCenters;
    }

    public FlipFitGymCenter getGymCenterById(String gymCenterId) {
        FlipFitGymCenter gymCenter = new FlipFitGymCenter();
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_GYM_CENTER_BY_ID);
            stmt.setString(1, gymCenterId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            gymCenter.setGymCenterId(rs.getString("gymCenterId"));
            gymCenter.setGymOwnerId(rs.getString("gymOwnerId"));
            gymCenter.setGymCenterName(rs.getString("gymCenterName"));
            gymCenter.setCity(rs.getString("city"));
            gymCenter.setCapacity(rs.getInt("capacity"));
            gymCenter.setPrice(rs.getInt("price"));
            gymCenter.setApproved(rs.getBoolean("isApproved"));
            stmt.close();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        return gymCenter;
    }

    public void addGymCenter(FlipFitGymCenter gymCenter) {

        System.out.println(gymCenter.toString());

        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.ADD_GYM_CENTER_QUERY);

            statement.setString(1,gymCenter.getGymCenterId());
            statement.setString(2,gymCenter.getGymOwnerId());
            statement.setString(3, gymCenter.getGymCenterName());
            statement.setString(4, gymCenter.getCity());
            statement.setInt(5, gymCenter.getCapacity());
            statement.setInt(6, gymCenter.getPrice());
            statement.setBoolean(7, gymCenter.isApproved());
            statement.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeGymCenter(String gymCenterId) {
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.REMOVE_GYM_CENTER_BY_ID);
            statement.setString(1, gymCenterId);
            statement.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FlipFitGymCenter> getPendingGymCentersList() {
        List<FlipFitGymCenter> pendingGymCentersList = new ArrayList<>();
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.GET_ALL_PENDING_GYM_CENTERS);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                FlipFitGymCenter gymCentre = new FlipFitGymCenter(
                        rs.getString("gymCenterId"),
                        rs.getString("gymOwnerId"),
                        rs.getString("gymCenterName"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getBoolean("isApproved")
                );
                gymCentre.setApproved(rs.getBoolean("isApproved"));
                pendingGymCentersList.add(gymCentre);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pendingGymCentersList;
    }

    public void validateGymCenter(String gymCenterId, boolean isApproved) {
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.APPROVE_GYM_CENTER_BY_ID);

            statement.setBoolean(1, isApproved);
            statement.setString(2, gymCenterId);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendGymCenterApprovalRequest(String gymCenterId) {
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.APPROVE_GYM_CENTER_BY_ID);
            statement.setInt(1,0);
            statement.setString(2, gymCenterId);
            statement.executeUpdate();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<FlipFitGymCenter> getGymCentersListByCity(String city) {
        List<FlipFitGymCenter> gymCentersList = new ArrayList<>();
        try {
            conn = DatabaseConnection.connect();
            System.out.println("city:" + city);

            statement = conn.prepareStatement(SQLConstants.GET_GYM_CENTERS_BY_CITY);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                FlipFitGymCenter gymCentre = new FlipFitGymCenter(
                        rs.getString("gymCenterId"),
                        rs.getString("gymCenterName"),
                        rs.getString("gymOwnerId"),
                        rs.getString("city"),
                        rs.getInt("capacity"),
                        rs.getInt("price"),
                        rs.getBoolean("isApproved")
                );
                gymCentersList.add(gymCentre);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return gymCentersList;
    }

}
