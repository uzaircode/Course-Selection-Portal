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

// The Course class represents a course offered by the university.
// It contains details information regarding on the course.
// This class is used in conjunction with the courseDelegation class to manage
// and display course information for students and faculties.
// The logic to handle action course, add course, update course & delete course
// is inside courseDelegation class.
public class Course extends CourseDelegation {
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
    private CourseDelegation delegation = new CourseDelegation();

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

    public String[] getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String[] subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String[] getEmploymentOpportunities() {
        return employmentOpportunities;
    }

    public void setEmploymentOpportunities(String[] employmentOpportunities) {
        this.employmentOpportunities = employmentOpportunities;
    }

    public String[] getScopeForFutherStudies() {
        return scopeForFutherStudies;
    }

    public void setScopeForFutherStudies(String[] scopeForFutherStudies) {
        this.scopeForFutherStudies = scopeForFutherStudies;
    }

    public boolean isScholarshipFacilities() {
        return scholarshipFacilities;
    }

    public void setScholarshipFacilities(boolean scholarshipFacilities) {
        this.scholarshipFacilities = scholarshipFacilities;
    }

    public int getFeeStructure() {
        return feeStructure;
    }

    public void setFeeStructure(int feeStructure) {
        this.feeStructure = feeStructure;
    }

    public int getMaximumStudent() {
        return maximumStudent;
    }

    public void setMaximumStudent(int maximumStudent) {
        this.maximumStudent = maximumStudent;
    }

    public MediumOfStudy getMediumStudy() {
        return mediumStudy;
    }

    public void setMediumStudy(MediumOfStudy mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static void setCourses(List<Course> courses) {
        Course.courses = courses;
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public void withdrawCourse() {
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

    // This method handleCourseActions uses delegation design pattern by delegating
    // the responsibility of handling course actions to the object referenced by the
    // delegation variable.
    public void handleCourseActions(User loggedInUser) {
        delegation.handleCourseActions(loggedInUser);
    }

    // This method addOfferedCourse uses delegation design pattern by delegating
    // the responsibility of add course actions to the object referenced by the
    // delegation variable.
    public void addOfferedCourse(User loggedInUser) {
        delegation.addOfferedCourse(loggedInUser, this);
    }

    // This method updateOfferedCourse uses delegation design pattern by delegating
    // the responsibility of update course actions to the object referenced by the
    // delegation variable.
    public void updateOfferedCourse(User loggedInUser) {
        delegation.updateOfferedCourse(loggedInUser);
    }

    // This method removeOfferedCourse uses delegation design pattern by delegating
    // the responsibility of delete course actions to the object referenced by the
    // delegation variable.
    public void removeOfferedCourse(User loggedInUser) {
        delegation.removeOfferedCourse(loggedInUser);
    }
}
