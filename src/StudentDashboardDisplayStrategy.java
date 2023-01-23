import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The StudentDashboardDisplayStrategy class is an implementation of the STRATEGY PATTERN.
// It provides a way for the application to handle the display of the student dashboard in a flexible and interchangeable manner.
// By implementing the strategy pattern, the application can easily switch between different display strategies (student/admin dashboard) affecting the rest of the code.
// Developers should use this class to handle the display of the student dashboard in their code and can extend or customize the functionality as needed.
public class StudentDashboardDisplayStrategy implements DashboardDisplayStrategy {

    AddressInfo theAddress = new AddressInfo();
    private static List<Student> listOfStudents = new ArrayList<Student>();
    Student loggedInUser = null;
    Scanner input = new Scanner(System.in);
    Course selectedCourse = new Course();
    private Course course = new Course();

    @Override
    public void displayUserPortal() {
        // logic to display student dashboard
        System.out.print("\033[H\033[2J");
        System.out.println("===== WELCOME TO STUDENT PORTAL =====");
        System.out.println("\n(1) LOGIN");
        System.out.println("(2) REGISTER");

        System.out.print("\nChoose 1 : ");
        int selection = input.nextInt();
        if (selection == 1) {
            displayUserLogin();
        } else if (selection == 2) {
            displayUserRegister();
        }
    }

    @Override
    public void displayUserLogin() {
        System.out.print("\033[H\033[2J");

        AddressInfo address = new AddressInfo("123 Main St", "Anytown", "Anystate",
                "12345", "USA");

        Student registeredStudent = Student.getInstance("johndoe", "123", "johndoe@example.com", 555 -
                555 - 5555, address,
                MediumStudy.UNDERGRADUATE, "Computer Science");
        listOfStudents.add(registeredStudent);

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== STUDENT LOGIN =====");
            System.out.print("\nEnter username: ");
            String inpUser = input.nextLine();
            System.out.print("Enter password: ");
            String inpPass = input.nextLine();

            // check if student is exist
            for (Student user : listOfStudents) {
                if (user.getUsername().equals(inpUser)) {
                    if (user.getPassword().equals(inpPass)) {
                        loggedInUser = user;
                        studentDashboard(loggedInUser);
                        break;
                    }
                } else {
                    System.out.println("Invalid username/password combination\n");
                    break;
                }
            }

        }
    }

    @Override
    public void displayUserRegister() {

        System.out.print("\033[H\033[2J");

        System.out.println("===== STUDENT REGISTRATION =====");
        System.out.print("\nEnter username      : ");
        String username = input.nextLine();

        System.out.print("Enter password      : ");
        String password = input.nextLine();

        System.out.print("Enter email address : ");
        String emailAddress = input.nextLine();

        System.out.print("Enter phone number  : ");
        int phoneNumber = Integer.parseInt(input.nextLine());

        System.out.println("\n===== ADDRESS INFORMATION =====");
        System.out.print("\nEnter street : ");
        String street = input.nextLine();

        System.out.print("Enter city : ");
        String city = input.nextLine();

        System.out.print("Enter state : ");
        String state = input.nextLine();

        System.out.print("Enter postalCode : ");
        String postalCode = input.nextLine();

        System.out.print("Enter country : ");
        String country = input.nextLine();

        AddressInfo theAddress = new AddressInfo(street, city, state, postalCode, country);
        MediumStudy medium = MediumStudy.valueOf("UNDERGRADUATE");

        Student registeredStudent = Student.getInstance(username, password,
                emailAddress, phoneNumber, theAddress, medium,
                "Computer Science");

        listOfStudents.add(registeredStudent);
        studentDashboard(registeredStudent);
    }

    public void studentDashboard(User loggedInUser) {
        loggedInUser.displayUserDashboard(loggedInUser);
    }

    public void displayAcademicCredentials() {
        // if (loggedInUser != null) {
        // System.out.println("Academic Credentials for " + loggedInUser.getUsername() +
        // ":");
        // System.out.println("Degree: " + loggedInUser.getDegree());
        // System.out.println("Major: " + loggedInUser.getMajor());
        // System.out.println("GPA: " + loggedInUser.getGpa());
        // } else {
        // System.out.println("You must be logged in to view your
        // academiccredentials.");
        // }
    }

    public void userInformation(User loggedInUser) {
        loggedInUser.displayUserInformation(loggedInUser);
    }

    public void addCourse(User loggedInUser) {
        course.handleAddCourse(loggedInUser);
    }

    public void updateCourse(User loggedInUser) {
        course.handleUpdateCourse(loggedInUser);
    }

    public void removeCourse(User loggedInUser) {
        course.handleRemoveCourse(loggedInUser);
    }

    public void manageCourse(User loggedInUser) {
        course.handleCourseActions(loggedInUser);
    }

    public void displayRegisteredCourse(User loggedInUser) {
        if (loggedInUser instanceof Student) {
            ((Student) loggedInUser).printRegisteredCourses(loggedInUser);
        } else if (loggedInUser instanceof Admin) {
            // ((Admin) loggedInUser).printAllCourse();
        }
    }

    public void userLogout(User loggedInUser) {
        loggedInUser.displayUserLogout(loggedInUser);
    }

}