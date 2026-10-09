package com.mycompany.oop_midterm;

import java.util.ArrayList;

public class MedicationManager {
    private ArrayList<Medication> medicationDatabase;

    public MedicationManager() {
        this.medicationDatabase = new ArrayList<>();
    }

    public void addMedication(Medication m) { medicationDatabase.add(m); }
    
    public void editMedication(String medName){}
    
    public Medication searchMedication(String medName) {
        for (Medication m : medicationDatabase) {
            if (m.getMedName().equalsIgnoreCase(medName)) return m;
        }
        return null;
    }
    
    public void deleteMedication(String medName){}
}