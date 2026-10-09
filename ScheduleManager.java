package com.mycompany.oop_midterm;

import java.time.LocalDate;
import java.util.ArrayList;

public class ScheduleManager {
    private ArrayList<MedicationSchedule> allActiveSchedules;

    public ScheduleManager() {
        this.allActiveSchedules = new ArrayList<>();
    }

    public MedicationSchedule createSchedule(Patient p, Medication m, LocalDate startDate, LocalDate endDate, String frequency) {
        String scheduleId = "SCH-" + System.currentTimeMillis();
        MedicationSchedule newSchedule = new MedicationSchedule(scheduleId, m, startDate, endDate, frequency);
        
        if (p != null) {
            p.addMedicationSchedule(newSchedule);
        }
        
        this.allActiveSchedules.add(newSchedule);
        return newSchedule;
    }

    public ArrayList<DoseRecord> getDailyAgenda(Patient p, LocalDate date) {
        ArrayList<DoseRecord> dailyAgenda = new ArrayList<>();
        if (p != null) {
            for (MedicationSchedule schedule : p.getMedicationScheduleList()) {
                if (schedule.isActive(date)) {
                    dailyAgenda.addAll(schedule.getDoseRecords());
                }
            }
        }
        return dailyAgenda;
    }

    public void cancelSchedule(String scheduleId) {
        allActiveSchedules.removeIf(schedule -> schedule.getScheduleId().equals(scheduleId));
    }

    public ArrayList<MedicationSchedule> getAllActiveSchedules() {
        return allActiveSchedules;
    }
}