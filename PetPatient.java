package com.mycompany.oop_midterm;

public class PetPatient extends Patient {
    private String species;
    private double weightKg;

    public PetPatient(String id, String name, String species, double weightKg) {
        super(id, name);
        this.species = species;
        this.weightKg = weightKg;
    }

    public String getSpecies() { return species; }
    public double getWeightKg() { return weightKg; }

    @Override
    public void displayPatientSummary() {
        System.out.println("Pet Patient: " + getName() + " (" + species + ", " + weightKg + "kg, ID: " + getId() + ")");
    }
}
