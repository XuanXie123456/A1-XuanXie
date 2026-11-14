public class Patient {
    private String patientName;
    private String mobileNumber;

    public Patient(String patientName, String mobileNumber) {
        // Basic validation: reject empty values
        if (patientName == null || patientName.isBlank() || mobileNumber == null || mobileNumber.isBlank()) {
            throw new IllegalArgumentException("Patient name and mobile cannot be blank");
        }
        this.patientName = patientName;
        this.mobileNumber = mobileNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "Patient Name: " + patientName + ", Mobile: " + mobileNumber;
    }
}
