import java.util.ArrayList;

public class Student extends User {

    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;

    public Student(String username, String password, String emailAddress, int phoneNumber, int studentId,
            AddressInfo homeAddress, MediumStudy mediumStudy, String faculty) {
        super(username, password, emailAddress, phoneNumber, homeAddress);
        this.studentId = studentId;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
