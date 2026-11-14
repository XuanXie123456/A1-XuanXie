public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional healthProfessional;
    private String timeSlot; // format "HH:mm", clinic: 08:00 - 16:00, 30min intervals

    public Appointment(Patient patient, HealthProfessional healthProfessional, String timeSlot) {
        if (patient == null || healthProfessional == null || timeSlot == null || timeSlot.isBlank()) {
            throw new IllegalArgumentException("All appointment details are required");
        }
        this.patient = patient;
        this.healthProfessional = healthProfessional;
        this.timeSlot = timeSlot;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    // Compare by time slot for sorting
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    public void printAppointmentDetails() {
        System.out.println("===== Appointment =====");
        System.out.println("Time Slot: " + timeSlot);
        System.out.println(patient);
        System.out.println("Health Professional ID: " + healthProfessional.getId() + ", Name: " + healthProfessional.getName());
        System.out.println("=======================");
    }

    @Override
    public String toString() {
        return "Time: " + timeSlot + " | " + patient + " | Provider ID: " + healthProfessional.getId();
    }
}
