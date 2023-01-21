import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum MediumOfStudy {
    FOUNDATION,
    DIPLOMA,
    UNDERGRADUATE,
    POSTGRADUATE,
    PHD;
}

public class Course {
    private String courseId;
    private String courseName;
    private String[] subjectTaught;
    private int courseDuration;
    private String[] employmentOpportunities;
    private String[] scopeForFutherStudies;
    private boolean scholarshipFacilities;
    private int feeStructure;
    private int maximumStudent;
    private MediumOfStudy mediumStudy;
    private Programme programme; // Composition

    private static List<Course> courses = new ArrayList<>();

    public Course(String courseId, String courseName, String[] subjectTaught, int courseDuration,
            String[] employmentOpportunities, String[] scopeForFutherStudies, boolean scholarshipFacilities,
            int feeStructure, int maximumStudent, MediumOfStudy mediumStudy) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.subjectTaught = subjectTaught;
        this.courseDuration = courseDuration;
        this.employmentOpportunities = employmentOpportunities;
        this.scopeForFutherStudies = scopeForFutherStudies;
        this.scholarshipFacilities = scholarshipFacilities;
        this.feeStructure = feeStructure;
        this.maximumStudent = maximumStudent;
        this.mediumStudy = mediumStudy;
    }

    public Course() {
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setSubjectTaught(String[] subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setEmploymentOpportunities(String[] employmentOpportunities) {
        this.employmentOpportunities = employmentOpportunities;
    }

    public void setScopeForFutherStudies(String[] scopeForFutherStudies) {
        this.scopeForFutherStudies = scopeForFutherStudies;
    }

    public void setScholarshipFacilities(boolean scholarshipFacilities) {
        this.scholarshipFacilities = scholarshipFacilities;
    }

    public void setFeeStructure(int feeStructure) {
        this.feeStructure = feeStructure;
    }

    public void setMaximumStudent(int maximumStudent) {
        this.maximumStudent = maximumStudent;
    }

    public void setMediumStudy(MediumOfStudy mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public static void setCourses(List<Course> courses) {
        Course.courses = courses;
    }

    @Override
    public String toString() {
        return "courseId : " + courseId + "\ncourseName : " + courseName + "\nsubjectTaught : "
                + Arrays.toString(subjectTaught) + "\ncourseDuration : " + courseDuration
                + "\nemploymentOpportunities : "
                + Arrays.toString(employmentOpportunities) + "\nscopeForFutherStudies : "
                + Arrays.toString(scopeForFutherStudies) + "\nscholarshipFacilities : " + scholarshipFacilities
                + "\nfeeStructure : " + feeStructure + "\nmaximumStudent : " + maximumStudent + "\nmediumStudy : "
                + mediumStudy + "\nprogramme : " + programme;
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public void withdrawCourse() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumStudent() {
        return maximumStudent;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public MediumOfStudy getMediumOfStudy() {
        return mediumStudy;
    }

    public Programme getProgramme() {
        return programme;
    }

    public String[] getSubjectsTaught() {
        return subjectTaught;
    }

    public void createCourses() {
        Course businessManagement = new Course("ODN3329", "Bachelor of Business Management (Hons.)",
                new String[] { "Data Structures", "Algorithms", "Programming Languages" },
                120,
                new String[] { "Masters in Computer Science",
                        "MBA in IT" },
                new String[] { "hello" },
                true, 14, 120, MediumOfStudy.FOUNDATION);

        courses.add(businessManagement);
    }

    public void displayCourseList() {

        // Course firstCourse = course.get(0);
        // System.out.println("Name of the first course: " +
        // firstCourse.getSubjectsTaught()[1]);

        // System.out.println("\n===== COURSE INFORMATION =====\n");
        // System.out.println("Elements of ArrayList are:\n");
        // for (int i = 0; i < course.size(); i++) {
        // System.out.println(course.get(i).toString() + " ");
        // System.out.println("\n");
        // }
        // System.out.println("\n");
    }

    public static List<Course> getAllCourses() {
        return courses;
    }

    public static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("Student has no courses yet.");
        } else {

            int i = 1;
            for (Course course : courses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }
        }
    }

    public void displayAllCourse() {
        // display all available course
        List<Course> courses = Course.getAllCourses();

        int i = 1;
        for (Course course : courses) {
            System.out.println("(" + i + ") " + course.getCourseName());
            i++;
        }
    }

}
