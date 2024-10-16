package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitRole;
import com.flipfit.bean.Person;
import com.flipfit.constant.SQLConstants;
import com.flipfit.exceptions.RegistrationFailedException;
import com.flipfit.exceptions.UserInvalidException;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FlipFitUserDAO implements FlipFitUserDAOInterface{

    public Person authenticate(String name, String password) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.CUSTOMER_LOGIN_QUERY);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Person(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        FlipFitRole.values()[rs.getInt("role_id")]
                );
            }
            ps.close();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void register(String name, String email, String password, String phoneNumber, String govId, int role_id)
//            throws RegistrationFailedException
    {
        try {
            Connection conn = DatabaseConnection.connect();
            conn.setAutoCommit(false);

            String personId = UUID.randomUUID().toString();

            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_NEW_PERSON);
            ps.setString(1, personId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, role_id);
            ps.executeUpdate();

            if(role_id == 1) {
                ps = conn.prepareStatement(SQLConstants.ADD_NEW_CUSTOMER);
                ps.setString(1, personId);
                ps.setString(2, phoneNumber);
                ps.setString(3,govId);
            }
            else if(role_id == 2){
                ps = conn.prepareStatement(SQLConstants.REGISTER_GYM_OWNER);
                ps.setString(1, personId);
                ps.setString(2, govId);
            }
            ps.executeUpdate();


            conn.commit();
            conn.setAutoCommit(true);
            ps.close();
        }
//        catch(SQLException e) {
//            throw new RegistrationFailedException("Failed to register the user. Try again.");
//        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public boolean checkIfUserExists(String name, String password) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.CUSTOMER_LOGIN_QUERY);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
            ps.close();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
