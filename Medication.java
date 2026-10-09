package com.mycompany.oop_midterm;

public class Medication {
    private String medName;
    private String dosage;

    public Medication(String medName, String dosage) {
        this.medName = medName; 
        this.dosage = dosage;
    }

    public String getMedName() { return medName; }
    public String getDosage() { return dosage; }

    public void displayDosingInstructions() {
        System.out.println("Medication: " + medName + " | Dosage: " + dosage);
    }
}