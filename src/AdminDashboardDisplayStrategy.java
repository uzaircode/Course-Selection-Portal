import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminDashboardDisplayStrategy implements DashboardDisplayStrategy {

    String username, password, emailAddress;
    int phoneNumber;
    AddressInfo theAddress = new AddressInfo();
    List<Admin> listOfUsers = new ArrayList<Admin>();
    Admin loggedInUser = null;
    Course selectedCourse = new Course();
    Scanner input = new Scanner(System.in);

    public void display() {
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
                // displayRegister();
            }
        }
    }

    public void displayLogin() {
        System.out.print("\033[H\033[2J");

        AddressInfo address = new AddressInfo("123 Main St", "Anytown", "USA", "12345", "Malaysia");
        listOfUsers.add(new Admin("A12345", "admin", "123", "admin@example.com", 123456789, address));

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== USER LOGIN =====");
            System.out.print("\nEnter username: ");
            String inpUser = input.nextLine();
            System.out.print("Enter password: ");
            String inpPass = input.nextLine();

            // check if admin is exist
            for (Admin user : listOfUsers) {
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
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("===== STUDENT REGISTRATION =====");
            System.out.print("\nEnter username      : ");
            String username = input.nextLine();

            System.out.print("Enter password      : ");
            password = input.nextLine();

            System.out.print("Enter email address : ");
            emailAddress = input.nextLine();

            System.out.print("Enter phone number  : ");
            phoneNumber = Integer.parseInt(input.nextLine());

            System.out.println("\n===== ADDRESS INFORMATION =====");
            System.out.print("\nEnter street     : ");
            String street = input.nextLine();
            theAddress.setStreet(street);

            System.out.print("Enter city       : ");
            String city = input.nextLine();
            theAddress.setCity(city);

            System.out.print("Enter state      : ");
            String state = input.nextLine();
            theAddress.setState(state);

            System.out.print("Enter postalCode : ");
            String postalCode = input.nextLine();
            theAddress.setPostalCode(postalCode);

            System.out.print("Enter country    : ");
            String country = input.nextLine();
            theAddress.setCountry(country);

            Admin registeredAdmin = new Admin(username, password, emailAddress, phoneNumber, theAddress);
            listOfUsers.add(registeredAdmin);
            adminDashboard(registeredAdmin);

            // displayStudentPortal();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void adminDashboard(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        System.out.println("===== ADMIN DASHBOARD =====");
        System.out.println("Welcome " + loggedInUser.getUsername() + "!");

        System.out.println("\n1. MANAGE PERSONAL INFORMATION");
        System.out.println("2. VIEW STUDENT LIST");
        System.out.println("3. MANAGE COURSES");
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
                userInformation(loggedInUser);
                break;
            case 2:
                // view student list;
                break;
            case 3:
                manageCourse(loggedInUser);
                break;
            case 4:
                userLogout(loggedInUser);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                adminDashboard(loggedInUser);
                return;
        }
    }

    public void userInformation(User loggedInUser) {
        loggedInUser.displayInformation(loggedInUser);
    }

    // This way of implement method follows both template pattern and the
    // open-closed principle.
    public void displayAddOfferedCourses(Course selectedCourse, User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.addOfferedCourse(selectedCourse, loggedInUser);
    }

    public void displayUpdateOfferedCourses(User loggedInUser) {
        loggedInUser.updateOfferedCourse(selectedCourse, loggedInUser);
    }

    // This way of implement method follows both template pattern and the
    // open-closed principle.
    public void displayRemoveOfferedCourse(User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.removeOfferedCourse(selectedCourse, loggedInUser);
    }

    public void manageCourse(User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.manageCourse(selectedCourse, loggedInUser);
    }

    public void userLogout(User loggedInUser) {
        System.out.println("User " + loggedInUser.getUsername() + " has been logout.");
        loggedInUser = null;
        Main.main(null);
    }
}