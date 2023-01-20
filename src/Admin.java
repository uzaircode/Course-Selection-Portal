import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements Dashboard, ICourseOperation {
    private String adminId;
    private AdminOperation adminOperation;

    public Admin() {
        this.adminOperation = new AdminOperation();
    }

    public Admin(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
            String adminId) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.adminId = adminId;
        this.adminOperation = new AdminOperation();
    }

    public Admin(String username, String password) {
        super(username, password);
        this.adminOperation = new AdminOperation();
    }

    public String getAdminId() {
        return adminId;
    }

    public void displayAddCourses(Course selectedCourse, User loggedInUser) {
        adminOperation.execute(selectedCourse, loggedInUser);
    }

    private class AdminOperation extends CourseOperation {
        @Override
        public void addCourse(Course selectedCourse, User loggedInUser) {
            System.out.print("\033[H\033[2J");
            try (Scanner input = new Scanner(System.in)) {
                System.out.println("===== CREATE NEW COURSE =====\n");
                System.out.print("Enter course name : ");
                String courseName = input.nextLine();

                // System.out.print("Enter course description: ");
                // String courseDescription = input.nextLine();
                // System.out.println("Enter the number of programme : ");
                // int arraySize = input.nextInt();

                // String[] programme = new String[arraySize];

                // System.out.println("Enter the name of the programme : ");
                // for (int i = 0; i < arraySize; i++) {
                // programme[i] = input.next();
                // }

                // System.out.print("Enter course duration : ");
                // int courseDuration = input.nextInt();

                // String[] dd = new String[arraySize];

                // System.out.println("Enter the name of the programme : ");
                // for (int i = 0; i < arraySize; i++) {
                // dd[i] = input.next();
                // }

                // String[] ee = new String[arraySize];

                // System.out.println("Enter the name of the programme : ");
                // for (int i = 0; i < arraySize; i++) {
                // ee[i] = input.next();
                // }

                // System.out.print("Enter Fee Structure : ");
                // int feeStructure = input.nextInt();

                // System.out.print("Enter maximum student : ");
                // int maximumStudent = input.nextInt();

                // System.out.println("Scholarship Facilities : ");
                // boolean scholarshipFacilities = input.nextBoolean();

                // Course c = new Course("2121212", courseName, programme, courseDuration, dd,
                // ee, true, feeStructure,
                // maximumStudent, MediumOfStudy.FOUNDATION);
                // Course science = new Course("ODN3829", "Bachelor of Science (Hons.)
                // Intelligent Robotics",
                // new String[] { "Data Structures", "Algorithms", "Programming Languages" },
                // 120,
                // new String[] { "Masters in Computer Science",
                // "MBA in IT" },
                // new String[] { "hello" },
                // true, 14, 120, MediumOfStudy.FOUNDATION);

                Course c = new Course(courseName);
                Course.addCourse(c);

                List<Course> allCourses = Course.getAllCourses();

                for (Course course : allCourses) {
                    System.out.println(course.getCourseName());
                }
                System.out.println("\nCourse " + c.getCourseName() + " has been created successfdeully.");

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    manageCourse(c, loggedInUser);
            } catch (

            NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    void displayInformation(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== ADMIN INFORMATION =====");
            System.out.println("Student Name  : " + loggedInUser.getUsername());
            System.out.println("Password      : " + loggedInUser.getPassword());
            System.out.println("Student ID    : " + ((Admin) loggedInUser).getAdminId());
            System.out.println("Email Address : " + loggedInUser.getEmailAddress());
            System.out.println("Phone Number  : " + loggedInUser.getPhoneNumber());
            // System.out.println("Faculty : " + loggedInUser.getFaculty());

            System.out.println("\n===== ADMIN ADDRESS INFORMATION =====");
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
    public void unregisteredFromCourse(Course course, User loggedInUser) {
        System.out.println("unregisteredFromCourse admin is working...");

    }

    @Override
    public void manageCourse(Course selectedCourse, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            List<Course> allCourses = Course.getAllCourses();

            for (Course course : allCourses) {
                System.out.println(course.getCourseName());
            }

            System.out.println("\n\n(1) ADD COURSE");
            System.out.println("(2) UPDATE COURSE");
            System.out.println("(3) DELETE COURSE");
            System.out.println("(4) RETURN TO DASHBOARD");

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
