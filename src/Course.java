import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

enum MediumOfStudy {
    FOUNDATION,
    DIPLOMA,
    UNDERGRADUATE,
    POSTGRADUATE,
    PHD;
}

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

    Scanner input = new Scanner(System.in);

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

    public void manageCourse(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            List<Course> allCourses = Course.getAllCourses();

            int i = 1;
            for (Course course : allCourses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.println("\n\n(1) ADD COURSE");
            System.out.println("(2) UPDATE COURSE");
            System.out.println("(3) DELETE COURSE");
            System.out.println("(4) RETURN TO DASHBOARD");

            System.out.print("\nChoose 1 : ");

            int choice = 0;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                return;
            }

            switch (choice) {
                case 1:
                    adminStrategy.displayAddOfferedCourses(loggedInUser);
                    break;
                case 2:
                    adminStrategy.displayUpdateOfferedCourses(loggedInUser);
                    break;
                case 3:
                    adminStrategy.displayRemoveOfferedCourse(loggedInUser);
                    break;
                case 4:
                    adminStrategy.adminDashboard(loggedInUser);
                default:
                    System.out.println("Invalid option, please try again.");
                    adminStrategy.adminDashboard(loggedInUser);
                    return;
            }
        }
    }

    public void addOfferedCourse(User loggedInUser) {
        delegation.addOfferedCourse(loggedInUser, this);
    }

    public void updateOfferedCourse(User loggedInUser) {
        delegation.updateOfferedCourse(loggedInUser);
    }

    public void removeOfferedCourse(User loggedInUser) {
        delegation.removeOfferedCourse(loggedInUser);
    }
}
