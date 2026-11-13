import java.util.List;

public class Paediatrician extends HealthProfessional {
    private int yearsOfPaediatricExperience;

    public Paediatrician(int id, String name, List<String> workingDays, int yearsOfPaediatricExperience) {
        super(id, name, workingDays);
        this.yearsOfPaediatricExperience = yearsOfPaediatricExperience;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Paediatrician ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Working Days: " + getWorkingDays());
        System.out.println("Paediatric Experience Years: " + yearsOfPaediatricExperience);
        System.out.println("--------------------------------");
    }

    public int getYearsOfPaediatricExperience() {
        return yearsOfPaediatricExperience;
    }
}
