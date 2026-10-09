package com.mycompany.oop_midterm;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicationSchedule {
    private String scheduleId;
    private Medication prescribedMed;
    private LocalDate startDate;
    private LocalDate endDate;
    private String frequency;
    private ArrayList<DoseRecord> doseRecords;

    public MedicationSchedule(String scheduleId, Medication prescribedMed, LocalDate startDate, LocalDate endDate, String frequency) {
        this.scheduleId = scheduleId;
        this.prescribedMed = prescribedMed;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
        this.doseRecords = new ArrayList<>();
    }

    public String getScheduleId() { return scheduleId; }
    public Medication getPrescribedMed() { return prescribedMed; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getFrequency() { return frequency; }
    public ArrayList<DoseRecord> getDoseRecords() { return doseRecords; }

    public void setFrequency(String frequency) { this.frequency = frequency; }

    public boolean isActive(LocalDate currentDate) {
        return (currentDate.isEqual(startDate) || currentDate.isAfter(startDate)) &&
               (currentDate.isEqual(endDate) || currentDate.isBefore(endDate));
    }

    public void generateDoseRecords() {
    }
}