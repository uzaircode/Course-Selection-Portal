import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private int courseDuration;
    private int maximumStudent;
    private MediumStudy mediumStudy;

    Course(String courseId, String courseName, int maximumStudent, int courseDuration, MediumStudy mediumStudy) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maximumStudent = maximumStudent;
        this.courseDuration = courseDuration;
        this.mediumStudy = mediumStudy;
    }

    @Override
    public String toString() {
        return "Course Name : " + this.getCourseName() + "\n" + "Maximum Student : " + this.getMaximumStudent() + "\n"
                + "Medium Study : " + this.getMediumStudy() + "\n" + "Course Duration : " + this.getCourseDuration()
                + "\n";
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

    public MediumStudy getMediumStudy() {
        return mediumStudy;
    }

    public void setMediumStudy(MediumStudy mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public void displayCourseList() {
        ArrayList<Course> course = new ArrayList<Course>();

        course.add(new Course("DLM2948", "Diploma in 3D Modelling & Animation ", 100, 14, MediumStudy.DIPLOMA));
        course.add(new Course("ODN3829", "Foundation in Arts ", 120, 14, MediumStudy.FOUNDATION));
        course.add(new Course("MPU1293", "Master of Computer Science (Software Engineering) ",
                80, 14, MediumStudy.POSTGRADUATE));

        System.out.print("\033[H\033[2J");
        System.out.println("\n===== COURSE INFORMATION =====\n");
        System.out.println("Elements of ArrayList are:\n");
        for (int i = 0; i < course.size(); i++) {
            System.out.println(course.get(i).toString() + " ");
        }
        System.out.println("\n");
    }
}
