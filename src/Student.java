import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Student extends User implements Dashboard, ICourseOperation {

    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;
    private List<Course> courses;
    private StudentOperation studentOperation;

    public Student() {
        this.studentOperation = new StudentOperation();
    }

    public void displayAddCourses(Course selectedCourse, User loggedInUser) {
        studentOperation.addCourse(selectedCourse, loggedInUser);
    }

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

    private class StudentOperation extends CourseOperation {

        @Override
        public void addCourse(Course selectedCourse, User loggedInUser) {
            System.out.print("\033[H\033[2J");
            Registration res = new Registration();

            try (Scanner input = new Scanner(System.in)) {
                System.out.println("===== BROWSE THE PROGRAMMES =====\n");

                // display all available course
                Course courseList = new Course();
                List<Course> availableCourses = courseList.getAllCourses();
                List<Course> studentCourses = ((Student) loggedInUser).getCourses();

                int i = 1;
                for (Course course : availableCourses) {
                    System.out.println("(" + i + ") " + course.getCourseName());
                    i++;
                }

                System.out.print("\nSelect a course to register for : ");
                int choice = input.nextInt();

                selectedCourse = availableCourses.get(choice - 1);

                boolean isRegistered = false;
                for (Course c : studentCourses) {
                    if (c.getCourseName().equalsIgnoreCase(selectedCourse.getCourseName())) {
                        isRegistered = true;
                        break;
                    }
                }

                if (!isRegistered) {
                    ((Student) loggedInUser).addCourses(selectedCourse);
                    System.out.println("\nYou have been registered to " + selectedCourse.getCourseName());
                } else {
                    System.out.println("\nYou are already registered for " + selectedCourse.getCourseName());
                }

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    res.manageCourse(loggedInUser);
            }

        }

    }

    @Override
    public void unregisteredFromCourse(Course course, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
        List<Course> registeredCourses = ((Student) loggedInUser).getCourses();

        System.out.println("=====  UNREGISTERED COURSES =====");

        if (registeredCourses.isEmpty()) {
            System.out.println("You haven't registered for any courses yet.");
            return;
        }

        for (int i = 0; i < registeredCourses.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + registeredCourses.get(i).getCourseName());
        }

        try (Scanner input = new Scanner(System.in)) {
            int choice = 0;
            System.out.print("\nSelect a course to unregister from : ");
            choice = input.nextInt();
            if (choice > 0 && choice <= registeredCourses.size()) {
                Course courseToUnregister = registeredCourses.get(choice - 1);
                ((Student) loggedInUser).removeCourse(courseToUnregister);
                System.out.println("You have been unregistered from "
                        + courseToUnregister.getCourseName());
                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    res.manageCourse(loggedInUser);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void printRegisteredCourses(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
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
                res.studentDashboard(loggedInUser);
        }
    }

    @Override
    void displayInformation(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
        try (Scanner input = new Scanner(System.in)) {
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
                res.studentDashboard(loggedInUser);
        }
    }

    @Override
    public void manageCourse(Course selectedCourse, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            Course courseList = new Course();
            List<Course> courses = courseList.getAllCourses();

            int i = 1;
            for (Course course : courses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.println("\n\n(1) ADD COURSE");
            System.out.println("(2) DELETE COURSE");
            System.out.println("(3) RETURN TO DASHBOARD");

            System.out.print("\nChoose 1 : ");
            int selection = input.nextInt();
            if (selection == 1) {
                res.displayAddCourses(selectedCourse, loggedInUser);
            } else if (selection == 2) {
                res.unregisterFromCourse(loggedInUser);
            } else if (selection == 3) {
                res.studentDashboard(loggedInUser);
            }

            System.out.print("\nChoose 1 : ");

            int choice = 0;
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                res.studentDashboard(loggedInUser);
                return;
            }

            switch (choice) {
                case 1:
                    res.displayAddCourses(selectedCourse, loggedInUser);
                    break;
                case 2:
                    res.unregisterFromCourse(loggedInUser);
                    break;
                case 3:
                    res.studentDashboard(loggedInUser);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    res.studentDashboard(loggedInUser);
                    return;
            }
        }
    }
}
