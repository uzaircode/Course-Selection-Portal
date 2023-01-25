// The relationship between faculty and course can be represented as composition.
// When a faculty is no longer needed, all of the courses that belong to that faculty will also be discarded.
public class Faculty {
    private String name;
    private String department;

    public Faculty(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
