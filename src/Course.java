import java.lang.reflect.Constructor;

public class Course {
    private String courseId;
    private String courseName;
    private int courseDuration;
    private int maximumStudent;

    Course(String courseId, String courseName, int maximumStudent, int courseDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maximumStudent = maximumStudent;
        this.courseDuration = courseDuration;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaximumStudent() {
        return maximumStudent;
    }

    public void setMaximumStudent(int maximumStudent) {
        this.maximumStudent = maximumStudent;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public static void main(String[] args) {
        Course c1 = new Course("DLM2948", "Object Oriented Programming & Analysis", 100, 14);
        Course c2 = new Course("ODN3829", "Software Engineering Fundamental", 120, 14);
        Course c3 = new Course("MPU1293", "Pengajian Islam", 80, 14);


        System.out.println("\n===== COURSE INFORMATION =====\n");
        System.out.println("Course Id       : " + c1.getCourseId());
        System.out.println("Course Name     : " + c1.getCourseName());
        System.out.println("Maximum Student : " + c1.getMaximumStudent());
        System.out.println("Course Duration : " + c1.getCourseDuration());

        System.out.println("\nCourse Id       : " + c2.getCourseId());
        System.out.println("Course Name     : " + c2.getCourseName());
        System.out.println("Maximum Student : " + c2.getMaximumStudent());
        System.out.println("Course Duration : " + c2.getCourseDuration());

        System.out.println("\nCourse Id       : " + c3.getCourseId());
        System.out.println("Course Name     : " + c3.getCourseName());
        System.out.println("Maximum Student : " + c3.getMaximumStudent());
        System.out.println("Course Duration : " + c3.getCourseDuration());
        System.out.println("\n");

    }

}
