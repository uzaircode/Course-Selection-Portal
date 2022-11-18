public class Student extends User {

    private int studentId;

    public Student(String username, String password, int studentId) {
        super(username, password);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        // set random number of student ID
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println(getUsername());
        System.out.println(getPassword());
        System.out.println(getStudentId());
    }
}
