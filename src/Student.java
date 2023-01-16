public class Student extends User {

    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;

    public Student(String username, String password, String emailAddress, int phoneNumber, int studentId,
            AddressInfo addressInfo, MediumStudy mediumStudy, String faculty) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.studentId = (int) (Math.random() * 9000000) + 1000000;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
    }

    public Student(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
    }

    public Student(String username, String password) {
        super(username, password);
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        studentId = (int) (Math.random() * 9000000) + 1000000;
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
