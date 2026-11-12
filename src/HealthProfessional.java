import java.util.ArrayList;
import java.util.List;

public abstract class HealthProfessional {
    private final int id;
    private String name;
    private List<String> workingDays;

    // Constructor
    public HealthProfessional(int id, String name, List<String> workingDays) {
        this.id = id;
        this.name = name;
        // Defensive copy to prevent external modification
        this.workingDays = new ArrayList<>(workingDays);
    }

    // Overload constructor (default empty working days)
    public HealthProfessional(int id, String name) {
        this.id = id;
        this.name = name;
        this.workingDays = new ArrayList<>();
    }

    // Getters (encapsulation: only read access, no setters for id)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getWorkingDays() {
        return new ArrayList<>(workingDays);
    }

    public void setWorkingDays(List<String> workingDays) {
        this.workingDays = new ArrayList<>(workingDays);
    }

    // Abstract method: force subclasses to implement their own details print (polymorphism)
    public abstract void printDetails();

    // toString for easy printing
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Working Days: " + workingDays;
    }

    // Equals based on ID (Part5 requirement: compare health professionals by ID)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthProfessional that = (HealthProfessional) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
