import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentManager {
    private List<Appointment> appointments;
    public static final List<String> VALID_TIME_SLOTS = List.of(
            "08:00","08:30","09:00","09:30","10:00","10:30",
            "11:00","11:30","12:00","12:30","13:00","13:30",
            "14:00","14:30","15:00","15:30","16:00"
    );

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    // Add appointment, check double booking + valid slot
    public String addAppointment(Appointment appointment) {
        if (!VALID_TIME_SLOTS.contains(appointment.getTimeSlot())) {
            return "ERROR: Time slot " + appointment.getTimeSlot() + " is not a valid clinic slot.";
        }
        // Check double booking
        for (Appointment a : appointments) {
            if (a.getHealthProfessional().equals(appointment.getHealthProfessional())
                    && a.getTimeSlot().equals(appointment.getTimeSlot())) {
                return "ERROR: Double booking! This health professional is already booked at " + appointment.getTimeSlot();
            }
        }
        appointments.add(appointment);
        return "SUCCESS: Appointment added.";
    }

    // View all sorted by time
    public List<Appointment> getAllSorted() {
        List<Appointment> copy = new ArrayList<>(appointments);
        Collections.sort(copy);
        return copy;
    }

    // Filter by health professional ID
    public List<Appointment> filterByProviderId(int providerId) {
        return appointments.stream()
                .filter(a -> a.getHealthProfessional().getId() == providerId)
                .sorted()
                .collect(Collectors.toList());
    }

    // Filter by patient mobile
    public List<Appointment> filterByPatientMobile(String mobile) {
        return appointments.stream()
                .filter(a -> a.getPatient().getMobileNumber().equals(mobile))
                .sorted()
                .collect(Collectors.toList());
    }

    // Cancel by provider ID + time slot
    public String cancelByProviderAndTime(int providerId, String time) {
        Appointment target = null;
        for (Appointment a : appointments) {
            if (a.getHealthProfessional().getId() == providerId && a.getTimeSlot().equals(time)) {
                target = a;
                break;
            }
        }
        if (target == null) {
            return "WARNING: No matching appointment found to cancel.";
        }
        appointments.remove(target);
        return "SUCCESS: Appointment cancelled.";
    }

    // Cancel all appointments for a patient by mobile
    public String cancelByPatientMobile(String mobile) {
        List<Appointment> toRemove = filterByPatientMobile(mobile);
        if (toRemove.isEmpty()) {
            return "WARNING: No appointments found for this mobile number.";
        }
        appointments.removeAll(toRemove);
        return "SUCCESS: All appointments for patient " + mobile + " cancelled.";
    }

    public List<Appointment> getRawAppointments() {
        return new ArrayList<>(appointments);
    }
}
