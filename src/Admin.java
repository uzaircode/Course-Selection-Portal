import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User {
    private String adminId;
    private static Scanner input = new Scanner(System.in);

    private Admin(String username, String password, String emailAddress, int phoneNumber,
            AddressInfo addressInfo) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
    }

    // this one is for dummy
    public Admin(String adminId, String string, String string2, String string3, int i,
            AddressInfo address) {
        super(string, string2, string3, i, address);
        this.adminId = adminId;
    }

    private static Admin instance;

    public static Admin getInstance(String username, String password, String emailAddress, int phoneNumber,
            AddressInfo addressInfo) {
        if (instance == null) {
            instance = new Admin(username, password, emailAddress, phoneNumber, addressInfo);
        }
        return instance;
    }

    private Admin() {

    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    void displayUserDashboard(User loggedInUser) {
        AdminDashboardDisplayStrategy adminDashboard = new AdminDashboardDisplayStrategy();
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
                adminDashboard.userInformation(loggedInUser);
                break;
            case 2:
                // view student list;
                break;
            case 3:
                adminDashboard.manageCourse(loggedInUser);
                break;
            case 4:
                adminDashboard.userLogout(loggedInUser);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                adminDashboard.adminDashboard(loggedInUser);
                return;
        }
    }

    @Override
    void displayInformation(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== ADMIN INFORMATION =====");
            System.out.println("Admin Name  : " + loggedInUser.getUsername());
            System.out.println("Password      : " + loggedInUser.getPassword());
            System.out.println("Admin ID    : " + ((Admin) loggedInUser).getAdminId());
            System.out.println("Email Address : " + loggedInUser.getEmailAddress());
            System.out.println("Phone Number  : " + loggedInUser.getPhoneNumber());

            System.out.println("\n===== ADMIN ADDRESS INFORMATION =====");
            System.out.println("Street       : " + loggedInUser.getAddressInfo().getStreet());
            System.out.println("City         : " + loggedInUser.getAddressInfo().getCity());
            System.out.println("State        : " + loggedInUser.getAddressInfo().getState());
            System.out.println("Postal Code  : " + loggedInUser.getAddressInfo().getPostalCode());
            System.out.println("Country      : " + loggedInUser.getAddressInfo().getCountry());

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                adminStrategy.adminDashboard(loggedInUser);
        }
    }
}
