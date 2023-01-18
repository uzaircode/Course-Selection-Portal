import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends User {

    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;
    private List<Course> courses;

    public Student(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
            MediumStudy mediumStudy, String faculty) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        Random rand = new Random();
        this.studentId = rand.nextInt((1000000000 - 100000000) + 1) + 100000000;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
    }

    public Student(String username, String password) {
        super(username, password);
        this.courses = new ArrayList<>();
    }

    public Student(String string) {
        this.courses = new ArrayList<>();

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        Random rand = new Random();
        studentId = rand.nextInt((1000000000 - 100000000) + 1) + 100000000;
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

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void printRegisteredCourses() {
        if (courses.isEmpty()) {
            System.out.println("No registered courses found");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : courses) {
                System.out.println(course.getCourseName());
            }
        }
    }
}
