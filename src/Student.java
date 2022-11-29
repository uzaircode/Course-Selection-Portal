import java.util.ArrayList;

public class Student extends User {

    private int studentId;
    private MediumStudy mediumStudy;

    public Student(String username, String password, int studentId, MediumStudy mediumStudy) {
        super(username, password);
        this.studentId = studentId;
        this.mediumStudy = mediumStudy;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public MediumStudy getMediumStudy() {
        return mediumStudy;
    }

    public void setMediumStudy(MediumStudy mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    // public void displayStudent() {
    // System.out.println(getUsername());
    // System.out.println(getPassword());
    // System.out.println(getStudentId());
    // }
}
