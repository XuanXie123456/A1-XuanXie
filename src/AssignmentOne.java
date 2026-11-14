import java.util.List;

public class AssignmentOne {
    public static void main(String[] args) {
        //PART 3: Create & print health professionals
        System.out.println("===== PART 3: HEALTH PROFESSIONALS =====");
        List<String> monWedFri = List.of("Monday", "Wednesday", "Friday");
        List<String> tueThu = List.of("Tuesday", "Thursday");

        HealthProfessional gp1 = new GeneralPractitioner(101, "Dr Alice Smith", monWedFri, "General Family Clinic");
        HealthProfessional gp2 = new GeneralPractitioner(102, "Dr Bob Brown", tueThu, "Suburb Clinic");
        HealthProfessional gp3 = new GeneralPractitioner(103, "Dr Claire Lee", monWedFri, "Inner City Clinic");
        HealthProfessional paed = new Paediatrician(201, "Dr Diana Wong", monWedFri, 12);
        HealthProfessional radio = new Radiologist(301, "Dr Eric Hall", tueThu, "CT & MRI");
        HealthProfessional nurse = new Nurse(401, "Nurse Fiona", monWedFri, true);

        // Polymorphic print
        HealthProfessional[] allProfessionals = {gp1, gp2, gp3, paed, radio, nurse};
        for (HealthProfessional hp : allProfessionals) {
            hp.printDetails();
        }

        //PART 6: Appointment System Demo
        System.out.println("\n===== PART 6: APPOINTMENT MANAGEMENT DEMO =====");
        AppointmentManager manager = new AppointmentManager();

        // Create patients
        Patient p1 = new Patient("Tom Wilson", "0411111111");
        Patient p2 = new Patient("Amy Jones", "0422222222");
        Patient p3 = new Patient("Jack Taylor", "0433333333");

        // Create appointments
        Appointment app1 = new Appointment(p1, gp1, "08:00");
        Appointment app2 = new Appointment(p2, paed, "09:00");
        Appointment app3 = new Appointment(p3, nurse, "08:30");
        Appointment duplicateBooking = new Appointment(p1, gp1, "08:00"); // duplicate for test

        // Add appointments
        System.out.println(manager.addAppointment(app1));
        System.out.println(manager.addAppointment(app2));
        System.out.println(manager.addAppointment(app3));
        System.out.println(manager.addAppointment(duplicateBooking)); // should fail double booking

        // Show all sorted appointments
        System.out.println("\n--- All appointments (sorted) ---");
        for (Appointment a : manager.getAllSorted()) {
            a.printAppointmentDetails();
        }

        // Filter by provider ID (paediatrician 201)
        System.out.println("\n--- Filter: provider ID 201 ---");
        for (Appointment a : manager.filterByProviderId(201)) {
            a.printAppointmentDetails();
        }

        // Filter by patient mobile
        System.out.println("\n--- Filter: patient mobile 0411111111 ---");
        for (Appointment a : manager.filterByPatientMobile("0411111111")) {
            a.printAppointmentDetails();
        }

        // Cancel by provider + time
        System.out.println("\nCancel provider 201 at 09:00: " + manager.cancelByProviderAndTime(201, "09:00"));

        // Try cancel non-existent appointment
        System.out.println("Cancel non-existent provider 999 at 10:00: " + manager.cancelByProviderAndTime(999, "10:00"));

        // Show updated list after cancellation
        System.out.println("\n--- Appointments after cancellation ---");
        for (Appointment a : manager.getAllSorted()) {
            a.printAppointmentDetails();
        }

        // Cancel by patient mobile
        System.out.println("\nCancel all for mobile 0433333333: " + manager.cancelByPatientMobile("0433333333"));

        System.out.println("\n--- Final appointment list ---");
        for (Appointment a : manager.getAllSorted()) {
            a.printAppointmentDetails();
        }
    }
}
