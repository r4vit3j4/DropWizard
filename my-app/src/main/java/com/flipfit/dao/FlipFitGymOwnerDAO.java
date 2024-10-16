package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.constant.SQLConstants;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAO implements FlipFitGymOwnerDAOInterface {
    private Connection conn = null;
    private PreparedStatement statement = null;
    private List<FlipFitGymOwner> gymOwnerList = new ArrayList<>();

    public FlipFitGymOwnerDAO() {}

    public void setGymOwnerList(List<FlipFitGymOwner> gymOwnerList) {
        this.gymOwnerList = gymOwnerList;
    }

    public List<FlipFitGymOwner> getGymOwnerList() {
        List<FlipFitGymOwner> resGymOwnerList = new ArrayList<>();
        try {
            conn = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.GET_ALL_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("govId")
                );
                resGymOwnerList.add(owner);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.setGymOwnerList(resGymOwnerList);
        return gymOwnerList;
    }

    public FlipFitGymOwner loginGymOwner(String username, String password) {
        try {
            conn = DatabaseConnection.connect();
            ResultSet result;

            try {
                statement = conn.prepareStatement(SQLConstants.LOGIN_GYM_OWNER);
                statement.setString(1, username);
                statement.setString(2, password);
                result = statement.executeQuery();
                while (result.next()) {
                    if (username.equals(result.getString("name")) && password.equals(result.getString("password"))) {
                        System.out.println("Login Success\n");
                        return new FlipFitGymOwner(
                                result.getString("id"),
                                result.getString("name"),
                                result.getString("email"),
                                result.getString("password"),
                                "");
                    } else {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void registerGymOwner(FlipFitGymOwner gymOwner){
        try{
            conn  = DatabaseConnection.connect();
            conn.setAutoCommit(false);

            statement = conn.prepareStatement(SQLConstants.ADD_NEW_PERSON);

            statement.setString(1,gymOwner.getId());
            statement.setString(2,gymOwner.getName());
            statement.setString(3,gymOwner.getEmail());
            statement.setString(4,gymOwner.getPassword());
            statement.setInt(5, gymOwner.getRole().ordinal());

            statement.executeUpdate();

            statement = conn.prepareStatement(SQLConstants.REGISTER_GYM_OWNER);
            statement.setString(1, gymOwner.getId());
            statement.setString(2, gymOwner.getGovId());

            statement.executeUpdate();

            conn.commit();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public FlipFitGymOwner getGymOwnerByOwnerId(String gymOwnerId) {
        try{
            conn  = DatabaseConnection.connect();
            statement = conn.prepareStatement(SQLConstants.GET_GYM_OWNER_BY_ID);

            statement.setString(1, gymOwnerId);


            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return new FlipFitGymOwner(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("govId")
                );
            }

        }catch(SQLException e){
            System.out.println("Try again with a different Username \n");
        }

        return null;
    }
}
