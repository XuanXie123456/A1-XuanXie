import java.util.List;

public class GeneralPractitioner extends HealthProfessional {
    private String clinicArea;

    public GeneralPractitioner(int id, String name, List<String> workingDays, String clinicArea) {
        super(id, name, workingDays);
        this.clinicArea = clinicArea;
    }

    public GeneralPractitioner(int id, String name, String clinicArea) {
        super(id, name);
        this.clinicArea = clinicArea;
    }

    @Override
    public void printDetails() {
        System.out.println("=== General Practitioner (GP) ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Working Days: " + getWorkingDays());
        System.out.println("Clinic Area: " + clinicArea);
        System.out.println("--------------------------------");
    }

    public String getClinicArea() {
        return clinicArea;
    }
}
