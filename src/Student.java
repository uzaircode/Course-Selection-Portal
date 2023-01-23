import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

enum MediumStudy {
    FOUNDATION,
    DIPLOMA,
    UNDERGRADUATE,
    POSTGRADUATE,
    PHD;
}

public final class Student extends User {
    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;
    private List<Course> courses;
    private static Scanner input = new Scanner(System.in);

    private Student(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
            MediumStudy mediumStudy, String faculty) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        Random rand = new Random();
        this.studentId = rand.nextInt((1000000000 - 100000000) + 1) + 100000000;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
    }

    private static Student instance;

    public static Student getInstance(String username, String password, String emailAddress, int phoneNumber,
            AddressInfo theAddress, MediumStudy mediumStudy, String major) {
        if (instance == null) {
            instance = new Student(username, password, emailAddress, phoneNumber, theAddress, mediumStudy,
                    major);
        }
        return instance;
    }

    private Student() {
        // private constructor
    }

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void printRegisteredCourses(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
        try (Scanner input = new Scanner(System.in)) {
            if (courses.isEmpty()) {
                System.out.println("No registered courses found");
            } else {
                System.out.println("Registered Courses:");
                for (Course course : courses) {
                    System.out.println(course.getCourseName());
                }
            }
            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                studStrategy.studentDashboard(loggedInUser);
        }
    }

    @Override
    void displayUserDashboard(User loggedInUser) {
        StudentDashboardDisplayStrategy studDashboard = new StudentDashboardDisplayStrategy();
        System.out.print("\033[H\033[2J");
        System.out.println("===== STUDENT DASHBOARD =====");
        System.out.println("Welcome " + loggedInUser.getUsername() + "!");

        System.out.println("\n1. MANAGE PERSONAL INFORMATION");
        System.out.println("2. VIEW AVAILABLE COURSES");
        System.out.println("3. VIEW SELECTED COURSES");
        System.out.println("4. LOGOUT");

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
                studDashboard.userInformation(loggedInUser);
                break;
            case 2:
                studDashboard.manageCourse(loggedInUser);
                break;
            case 3:
                studDashboard.displayRegisteredCourse(loggedInUser);
                break;
            case 4:
                studDashboard.userLogout(loggedInUser);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                studDashboard.studentDashboard(loggedInUser);
                return;
        }
    }

    @Override
    void displayInformation(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
        System.out.println("===== STUDENT INFORMATION =====");
        System.out.println("Student Name  : " + loggedInUser.getUsername());
        System.out.println("Password      : " + loggedInUser.getPassword());
        System.out.println("Student ID    : " + ((Student) loggedInUser).getStudentId());
        System.out.println("Email Address : " + loggedInUser.getEmailAddress());
        System.out.println("Phone Number  : " + loggedInUser.getPhoneNumber());
        // System.out.println("Faculty : " + loggedInUser.getFaculty());

        System.out.println("\n===== STUDENT ADDRESS INFORMATION =====");
        System.out.println("Street       : " + loggedInUser.getAddressInfo().getStreet());
        System.out.println("City         : " + loggedInUser.getAddressInfo().getCity());
        System.out.println("State        : " + loggedInUser.getAddressInfo().getState());
        System.out.println("Postal Code  : " + loggedInUser.getAddressInfo().getPostalCode());
        System.out.println("Country      : " + loggedInUser.getAddressInfo().getCountry());

        System.out.print("\nPress 0 to return : ");
        int selection = input.nextInt();
        if (selection == 0)
            studStrategy.studentDashboard(loggedInUser);
    }

}
