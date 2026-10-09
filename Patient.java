package com.mycompany.oop_midterm;

import java.util.ArrayList;

public abstract class Patient implements Summarizable {
    private String id;
    private String name;
    private ArrayList<MedicationSchedule> medicationScheduleList;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.medicationScheduleList = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    
    public void addMedicationSchedule(MedicationSchedule ms) {
        this.medicationScheduleList.add(ms);
    }
    
    public ArrayList<MedicationSchedule> getMedicationScheduleList() {
        return medicationScheduleList;
    }

    @Override
    public abstract void displayPatientSummary();
}


