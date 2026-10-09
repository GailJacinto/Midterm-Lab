package com.mycompany.oop_midterm;

public class HumanPatient extends Patient {
    private int age;

    public HumanPatient(String id, String name, int age) {
        super(id, name); 
        this.age = age;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public void displayPatientSummary() {
        System.out.println("Human Patient: " + getName() + " (Age: " + age + ", ID: " + getId() + ")");
    }
}