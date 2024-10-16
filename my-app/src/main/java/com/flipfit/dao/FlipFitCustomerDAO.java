package com.flipfit.dao;

import com.flipfit.bean.FlipFitCustomer;
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

public class FlipFitCustomerDAO implements FlipFitCustomerDAOInterface {

    public void registerCustomer(String name, String email, String password, String phoneNumber,String govId) throws RegistrationFailedException{
        try {
            Connection conn = DatabaseConnection.connect();
            conn.setAutoCommit(false);

            String personId = UUID.randomUUID().toString();

            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_NEW_PERSON);
            ps.setString(1, personId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setInt(5, FlipFitRole.CUSTOMER.ordinal());
            ps.executeUpdate();

            ps = conn.prepareStatement(SQLConstants.ADD_NEW_CUSTOMER);
            ps.setString(1, personId);
            ps.setString(2, phoneNumber);
            ps.setString(3,govId);
            ps.executeUpdate();

            conn.commit();
            ps.close();
        } catch(SQLException e) {
            throw new RegistrationFailedException("Failed to register the user. Try again.");
        }catch (Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }


    }

    public Person getPersonByName(String name) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_PERSON_BY_ID);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Person person = new Person(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    FlipFitRole.values()[rs.getInt("role_id")]
            );
            ps.close();
            return person;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean isUserValid(String name, String password) throws UserInvalidException{
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.CUSTOMER_LOGIN_QUERY);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ps.close();
                return true;
            }
            ps.close();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public FlipFitCustomer getCustomerByName(String name) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_CUSTOMER_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            FlipFitCustomer flipFitCustomer = new FlipFitCustomer(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phoneNumber"),
                    rs.getString("govId")
            );
            ps.close();
            return flipFitCustomer;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
