import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDashboardDisplayStrategy implements DashboardDisplayStrategy {

    AddressInfo theAddress = new AddressInfo();
    private static List<Admin> ListOfAdmins = new ArrayList<Admin>();
    Admin loggedInUser = null;
    Course selectedCourse = new Course();
    private Course course = new Course();
    private static Scanner input = new Scanner(System.in);

    public void userDisplayPortal() {
        // logic to display admin dashboard
        System.out.print("\033[H\033[2J");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== WELCOME TO ADMIN PORTAL =====");
            System.out.println("\n(1) LOGIN");
            System.out.println("(2) REGISTER");

            System.out.print("\nChoose 1 : ");
            int selection = input.nextInt();
            if (selection == 1) {
                displayLogin();
            } else if (selection == 2) {
                displayRegister();
            }
        }
    }

    public void displayLogin() {
        System.out.print("\033[H\033[2J");

        AddressInfo address = new AddressInfo("123 Main St", "Anytown", "USA", "12345", "Malaysia");
        ListOfAdmins.add(new Admin("A12345", "admin", "123", "admin@example.com", 123456789, address));

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

    public void displayRegister() {
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

    public void userInformation(User loggedInUser) {
        loggedInUser.displayInformation(loggedInUser);
    }

    public void displayAddOfferedCourses(User loggedInUser) {
        course.addOfferedCourse(loggedInUser);
    }

    public void displayUpdateOfferedCourses(User loggedInUser) {
        course.updateOfferedCourse(loggedInUser);
    }

    public void displayRemoveOfferedCourse(User loggedInUser) {
        course.removeOfferedCourse(loggedInUser);
    }

    public void manageCourse(User loggedInUser) {
        course.manageCourse(loggedInUser);
    }

    public void userLogout(User loggedInUser) {
        loggedInUser.userLogout(loggedInUser);
    }
}