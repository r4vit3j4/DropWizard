package com.flipfit.helper;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;

import java.util.Date;
import java.util.List;

public class Helper {

    public static void printGymCenters(List<FlipFitGymCenter> gymCenters) {
        System.out.println("============================================================================================================================================");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s\n", "CENTER_ID", "OWNER_ID", "CENTER_NAME", "CITY", "CAPACITY", "PRICE", "APPROVED");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(FlipFitGymCenter gymCenter: gymCenters) {
            System.out.format("%15s %15s %15s %15s %15s %15s %15s\n", gymCenter.getGymCenterId(), gymCenter.getGymOwnerId(), gymCenter.getGymCenterName(), gymCenter.getCity(), gymCenter.getCapacity(), gymCenter.getPrice(), gymCenter.isApproved());
        }
        System.out.println("============================================================================================================================================\n\n");
    }

    public static void printCustomerProfile(FlipFitCustomer customer){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("USER ID: " + customer.getId());
        System.out.println("USER NAME: " + customer.getName());
        System.out.println("EMAIL: " + customer.getEmail());
        System.out.println("CONTACT: " + customer.getPhoneNumber());
        System.out.println("------------------------------------------------------------------------");
    }

    public static void printSlots(List<FlipFitSlot> slots){
        System.out.println("============================================================================================================================================");
        System.out.printf("%15s %15s\n", "SLOT-ID", "SLOT_TIME");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(FlipFitSlot slot: slots) {
            System.out.format("%15s %15s\n", slot.getSlotId(), slot.getSlotTime());
        }
        System.out.println("============================================================================================================================================\n\n");
    }

    public static Date selectDate() {
        return new Date();
    }
}
