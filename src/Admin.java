import java.util.Scanner;

public class Admin extends User {
    private String adminId;

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
                adminStrategy.adminDashboard(loggedInUser);
        }
    }
}
