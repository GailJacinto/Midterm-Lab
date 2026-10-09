package com.mycompany.oop_midterm;

import java.util.Scanner;
import java.time.LocalDate;

public class MediTrackApp {
    
    private static boolean isIdTaken(Caregiver caregiver, String id) {
        for (Patient p : caregiver.getManagedPatients()) {
            if (p.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Caregiver user = new Caregiver("PrimaryCaregiver1");
        ScheduleManager scheduleManager = new ScheduleManager();
        boolean running = true;

        System.out.println("--- MediTrack System ---");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Human Patient");
            System.out.println("2. Add Pet Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Assign Medication to Patient");
            System.out.println("5. View Patient's Medication Schedule");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid menu number.");
                continue;
            }

            switch (choice) {
                case 1:
                    String hId = "";
                    while (true) {
                        System.out.print("Enter ID: ");
                        hId = scanner.nextLine().trim();
                        if (hId.isEmpty()) {
                            System.out.println("Error: ID cannot be empty.");
                        } else if (isIdTaken(user, hId)) {
                            System.out.println("Error: A patient with this ID already exists. Please choose a unique ID.");
                        } else {
                            break;
                        }
                    }

                    String hName = "";
                    while (hName.trim().isEmpty()) {
                        System.out.print("Enter Name: ");
                        hName = scanner.nextLine();
                        if (hName.trim().isEmpty()) {
                            System.out.println("Error: Name cannot be empty.");
                        }
                    }

                    int age = -1;
                    while (age < 0) {
                        System.out.print("Enter Age: ");
                        try {
                            age = Integer.parseInt(scanner.nextLine().trim());
                            if (age < 0) {
                                System.out.println("Error: Age cannot be negative.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid number format. Please enter a positive whole number.");
                        }
                    }
                    
                    Patient newHuman = new HumanPatient(hId, hName, age);
                    user.registerPatient(newHuman);
                    System.out.println("Human patient added.");
                    break;

                case 2:
                    String pId = "";
                    while (true) {
                        System.out.print("Enter ID: ");
                        pId = scanner.nextLine().trim();
                        if (pId.isEmpty()) {
                            System.out.println("Error: ID cannot be empty.");
                        } else if (isIdTaken(user, pId)) {
                            System.out.println("Error: A patient with this ID already exists. Please choose a unique ID.");
                        } else {
                            break;
                        }
                    }

                    String pName = "";
                    while (pName.trim().isEmpty()) {
                        System.out.print("Enter Name: ");
                        pName = scanner.nextLine();
                        if (pName.trim().isEmpty()) {
                            System.out.println("Error: Name cannot be empty.");
                        }
                    }

                    String species = "";
                    while (species.trim().isEmpty()) {
                        System.out.print("Enter Species: ");
                        species = scanner.nextLine();
                        if (species.trim().isEmpty()) {
                            System.out.println("Error: Species cannot be empty.");
                        }
                    }

                    double weight = -1.0;
                    while (weight <= 0) {
                        System.out.print("Enter Weight (kg): ");
                        try {
                            weight = Double.parseDouble(scanner.nextLine().trim());
                            if (weight <= 0) {
                                System.out.println("Error: Weight must be greater than 0 kg.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid numeric format. Please enter a valid weight decimal.");
                        }
                    }
                    
                    Patient newPet = new PetPatient(pId, pName, species, weight);
                    user.registerPatient(newPet);
                    System.out.println("Pet patient added.");
                    break;

                case 3:
                    System.out.println("\n--- Registered Patients ---");
                    if (user.getManagedPatients().isEmpty()) {
                        System.out.println("No patients registered yet.");
                    } else {
                        for (Patient p : user.getManagedPatients()) {
                            p.displayPatientSummary(); 
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Patient ID to assign medication: ");
                    String searchId = scanner.nextLine().trim();
                    Patient foundPatient = null;
                    
                    for (Patient p : user.getManagedPatients()) {
                        if (p.getId().equalsIgnoreCase(searchId)) {
                            foundPatient = p;
                            break;
                        }
                    }

                    if (foundPatient != null) {
                        String medName = "";
                        while (medName.trim().isEmpty()) {
                            System.out.print("Enter Medication Name: ");
                            medName = scanner.nextLine();
                            if (medName.trim().isEmpty()) {
                                System.out.println("Error: Medication name cannot be empty.");
                            }
                        }

                        String dosage = "";
                        while (dosage.trim().isEmpty()) {
                            System.out.print("Enter Dosage (e.g., 500mg, 1 tablet): ");
                            dosage = scanner.nextLine();
                            if (dosage.trim().isEmpty()) {
                                System.out.println("Error: Dosage cannot be empty.");
                            }
                        }

                        String frequency = "";
                        while (frequency.trim().isEmpty()) {
                            System.out.print("Enter Frequency (e.g., Once daily, Every 8 hours): ");
                            frequency = scanner.nextLine();
                            if (frequency.trim().isEmpty()) {
                                System.out.println("Error: Frequency cannot be empty.");
                            }
                        }

                        int days = 0;
                        while (days <= 0) {
                            System.out.print("Enter Treatment Duration in Days: ");
                            try {
                                days = Integer.parseInt(scanner.nextLine().trim());
                                if (days <= 0) {
                                    System.out.println("Error: Treatment duration must be at least 1 day.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Please enter a valid number of days.");
                            }
                        }

                        Medication newMed = new Medication(medName, dosage);
                        LocalDate startDate = LocalDate.now();
                        LocalDate endDate = startDate.plusDays(days);

                        scheduleManager.createSchedule(foundPatient, newMed, startDate, endDate, frequency);
                        System.out.println("Medication assigned successfully to " + foundPatient.getName());
                    } else {
                        System.out.println("Patient ID not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Patient ID to view schedule: ");
                    String viewId = scanner.nextLine().trim();
                    Patient viewPatient = null;
                    
                    for (Patient p : user.getManagedPatients()) {
                        if (p.getId().equalsIgnoreCase(viewId)) {
                            viewPatient = p;
                            break;
                        }
                    }

                    if (viewPatient != null) {
                        System.out.println("\n--- Active Schedule for " + viewPatient.getName() + " ---");
                        if (viewPatient.getMedicationScheduleList().isEmpty()) {
                            System.out.println("No medications currently assigned.");
                        } else {
                            for (MedicationSchedule ms : viewPatient.getMedicationScheduleList()) {
                                System.out.println("- " + ms.getPrescribedMed().getMedName() + 
                                                   " (" + ms.getPrescribedMed().getDosage() + ")");
                                System.out.println("   Frequency: " + ms.getFrequency());
                                System.out.println("   Treatment Period: " + ms.getStartDate() + 
                                                   " to " + ms.getEndDate());
                            }
                        }
                    } else {
                        System.out.println("Patient ID not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting MediTrack...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}