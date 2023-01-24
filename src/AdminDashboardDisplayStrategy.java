import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The AdminDashboardDisplayStrategy class is an implementation of the STRATEGY PATTERN and POLYMORPHISM.
// It provides a way for the application to handle the display of the admin dashboard in a flexible and interchangeable manner.
// By implementing the strategy pattern, the application can easily switch between different display strategies (student/admin dashboard) without affecting the rest of the code.
// Developers should use this class to handle the display of the admin dashboard in their code and can extend or customize the functionality as needed.
public class AdminDashboardDisplayStrategy implements DashboardDisplayStrategy {

    AddressInfo theAddress = new AddressInfo();
    private static List<Admin> ListOfAdmins = new ArrayList<Admin>();
    Admin loggedInUser = null;
    Course selectedCourse = new Course();
    private Course course = new Course();
    private static Scanner input = new Scanner(System.in);

    @Override
    public void displayUserPortal() {
        // logic to display admin dashboard
        System.out.print("\033[H\033[2J");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== WELCOME TO ADMIN PORTAL =====");
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
    }

    @Override
    public void displayUserLogin() {
        System.out.print("\033[H\033[2J");

        // DINA, IGNORE THIS PART. IT USE TO STORE DUMMY COURSE OBJECT FOR TERMINAL
        // DISPLAY
        // NOT RELATED TO GUI
        AddressInfo address = new AddressInfo("123 Main St", "Anytown", "USA", "12345", "Malaysia");
        ListOfAdmins.add(new Admin("A12345", "admin", "123", "admin@example.com", 123456789, address));

        // DINA, IGNORE THIS PART. IT USE TO STORE DUMMY COURSE OBJECT FOR TERMINAL
        // DISPLAY
        // NOT RELATED TO GUI
        Course courses = new Course();
        courses.createCourses();

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== ADMIN LOGIN =====");
            System.out.print("\nEnter username: ");
            String inpUser = input.nextLine();
            System.out.print("Enter password: ");
            String inpPass = input.nextLine();

            // check if admin is exist
            for (Admin user : ListOfAdmins) {
                if (user.getUsername().equals(inpUser)) {
                    if (user.getPassword().equals(inpPass)) {
                        loggedInUser = user;
                        adminDashboard(loggedInUser);
                        break;
                    }
                } else {
                    System.out.println("Invalid username/password combination\n");
                }
            }
            if (loggedInUser == null) {
                System.out.println("Invalid username/password combination\n");
            }

        }
    }

    @Override
    public void displayUserRegister() {
        System.out.print("\033[H\033[2J");

        System.out.println("===== ADMIN REGISTRATION =====");
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
        Admin registeredAdmin = Admin.getInstance(username, password, emailAddress, phoneNumber, theAddress);

        ListOfAdmins.add(registeredAdmin);
        adminDashboard(registeredAdmin);
    }

    public void adminDashboard(User loggedInUser) {
        loggedInUser.displayUserDashboard(loggedInUser);
    }

    public void adminInformation(User loggedInUser) {
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

    public void userLogout(User loggedInUser) {
        loggedInUser.displayUserLogout(loggedInUser);
    }
}