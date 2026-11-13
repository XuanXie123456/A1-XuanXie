import java.util.List;

public class Nurse extends HealthProfessional {
    private boolean canTakeBloodSample;

    public Nurse(int id, String name, List<String> workingDays, boolean canTakeBloodSample) {
        super(id, name, workingDays);
        this.canTakeBloodSample = canTakeBloodSample;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Nurse ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Working Days: " + getWorkingDays());
        System.out.println("Able to take blood sample: " + canTakeBloodSample);
        System.out.println("--------------------------------");
    }

    public boolean isCanTakeBloodSample() {
        return canTakeBloodSample;
    }
}
