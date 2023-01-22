import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentDashboardDisplayStrategy implements DashboardDisplayStrategy {

    String username, password, emailAddress;
    int phoneNumber;
    AddressInfo theAddress = new AddressInfo();
    List<Student> listOfStudents = new ArrayList<Student>();
    Student loggedInStudent = null;
    Scanner input = new Scanner(System.in);

    public void display() {
        // logic to display student dashboard
        System.out.print("\033[H\033[2J");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== WELCOME TO STUDENT PORTAL =====");
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

        AddressInfo address = new AddressInfo("123 Main St", "Anytown", "Anystate", "12345", "USA");
        listOfStudents.add(new Student("johndoe", "123", "johndoe@example.com", 555 - 555 - 5555, address,
                MediumStudy.UNDERGRADUATE, "Computer Science"));

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
                        loggedInStudent = user;
                        studentDashboard(loggedInStudent);
                        break;
                    }
                } else {
                    System.out.println("Invalid username/password combination\n");
                    break;
                }
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

            Student registeredStudent = new Student(username, password, emailAddress, phoneNumber, theAddress,
                    MediumStudy.UNDERGRADUATE, "Computer Science");
            listOfStudents.add(registeredStudent);
            studentDashboard(registeredStudent);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void studentDashboard(User loggedInUser) {

        System.out.print("\033[H\033[2J");
        System.out.println("===== STUDENT DASHBOARD =====");
        System.out.println("Welcome " + loggedInUser.getUsername() + "!");

        System.out.println("\n1. MANAGE PERSONAL INFORMATION");
        System.out.println("2. VIEW ACADEMIC CREDENTIALS");
        System.out.println("3. VIEW AVAILABLE COURSES");
        System.out.println("4. VIEW SELECTED COURSES");
        System.out.println("5. LOGOUT");

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
                // academicCredential();
                break;
            case 3:
                manageCourse(loggedInUser);
                break;
            case 4:
                displayRegisteredCourse(loggedInUser);
                break;
            case 5:
                userLogout(loggedInUser);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                studentDashboard(loggedInUser);
                return;
        }

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
        loggedInUser.displayInformation(loggedInUser);
    }

    // This way of implement method follows both template pattern and the
    // open-closed principle.
    public void displayAddOfferedCourses(User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.addOfferedCourse();
    }

    // This way of implement method follows both template pattern and the
    // open-closed principle.
    public void displayRemoveOfferedCourse(User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.removeOfferedCourse();
    }

    public void manageCourse(User loggedInUser) {
        ICourseOperation operation = (ICourseOperation) loggedInUser;
        operation.manageCourse();
    }

    public void displayRegisteredCourse(User loggedInUser) {
        if (loggedInUser instanceof Student) {
            ((Student) loggedInUser).printRegisteredCourses(loggedInUser);
        } else if (loggedInUser instanceof Admin) {
            // ((Admin) loggedInUser).printAllCourse();
        }
    }

    public void userLogout(User loggedInUser) {
        System.out.println("User " + loggedInUser.getUsername() + " has been logout.");
        loggedInUser = null;
        Main.main(null);
    }

}