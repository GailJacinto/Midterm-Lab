package com.mycompany.oop_midterm;

import java.util.ArrayList;

public class Caregiver {
    private String username;
    private ArrayList<Patient> managedPatients;

    public Caregiver(String username) {
        this.username = username;
        this.managedPatients = new ArrayList<>();
    }

    public String getUsername() { return username; }
    
    public void registerPatient(Patient p) {
        managedPatients.add(p);
    }
    
    public ArrayList<Patient> getManagedPatients() { return managedPatients; }
}