import java.util.List;

public class Radiologist extends HealthProfessional {
    private String imagingSpecialty;

    public Radiologist(int id, String name, List<String> workingDays, String imagingSpecialty) {
        super(id, name, workingDays);
        this.imagingSpecialty = imagingSpecialty;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Radiologist ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Working Days: " + getWorkingDays());
        System.out.println("Imaging Specialty: " + imagingSpecialty);
        System.out.println("--------------------------------");
    }

    public String getImagingSpecialty() {
        return imagingSpecialty;
    }
}
