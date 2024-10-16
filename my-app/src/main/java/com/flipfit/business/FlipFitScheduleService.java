package com.flipfit.business;

import com.flipfit.bean.FlipFitSchedule;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.dao.FlipFitScheduleDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlipFitScheduleService implements FlipFitScheduleInterface {

    private final FlipFitGymCenterService gymCenterService = new FlipFitGymCenterService();
    private final FlipFitSlotService slotService = new FlipFitSlotService();
    private final FlipFitScheduleDAO flipFitScheduleDAO = new FlipFitScheduleDAO();

    public FlipFitSchedule createSchedule(Date date, String slotId) {
        try {
            String centreID = slotService.getSlotById(slotId).getGymCenterId();
            int availability = gymCenterService.getGymCenterById(centreID).getCapacity();
            FlipFitSchedule schedule = new FlipFitSchedule(date, slotId, availability);
            flipFitScheduleDAO.addSchedule(schedule);
            System.out.println("Schedule created");
            return schedule;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public FlipFitSchedule getScheduleByDateAndSlotId(Date date, String slotId) {
        List<FlipFitSchedule> scheduleList = flipFitScheduleDAO.getScheduleListByDate(date);
        return scheduleList.stream()
                .filter(schedule -> schedule.getSlotId().equals(slotId))
                .findFirst()
                .orElse(null);
    }

    public boolean modifySchedule(String scheduleId, int action) {
        return flipFitScheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<FlipFitSchedule> checkAvailability(String centerId, Date date) {
        List<FlipFitSlot> allSlotsForGym = slotService.getAllSlotsByGymCenter(centerId);
        List<FlipFitSchedule> allAvailableSchedules = new ArrayList<>();
        allSlotsForGym.forEach(slot -> {
            String slotId = slot.getSlotId();
            System.out.println("Checking availability");
            FlipFitSchedule schedule = getOrCreateSchedule(slotId, date);
            if (schedule.getAvailability() > 0) {
                allAvailableSchedules.add(schedule);
            }
        });
        return allAvailableSchedules;
    }

    public List<FlipFitSlot> getAllAvailableSlotsByDate(String centerId, Date date) {
        System.out.println(5);
        List<FlipFitSlot> allSlotsOfThatCentre = slotService.getAllSlotsByGymCenter(centerId);
        List<FlipFitSlot> response = new ArrayList<>(allSlotsOfThatCentre);

        allSlotsOfThatCentre.forEach(slot -> System.out.println(slot.toString()));

        flipFitScheduleDAO.getScheduleListByDate(date).forEach(schedule -> {
            if (slotService.getSlotById(schedule.getSlotId()).getGymCenterId().equals(centerId)) {
                if (schedule.getAvailability() <= 0) {
                    response.remove(slotService.getSlotById(schedule.getSlotId()));
                }
            }
        });

        return response;
    }

    public FlipFitSchedule getSchedule(String scheduleID) {
        return flipFitScheduleDAO.getScheduleById(scheduleID);
    }

    public FlipFitSchedule getOrCreateSchedule(String slotId, Date date) {
        FlipFitSchedule schedule = getScheduleByDateAndSlotId(date, slotId);
        if (schedule == null) {
            return createSchedule(date, slotId);
        }
        return schedule;
    }
}
