import java.util.Scanner;

public class Admin extends User implements Dashboard, ICourseOperation {
    private String adminId;

    public Admin(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
            String adminId) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.adminId = adminId;
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
    }

    public String getAdminId() {
        return adminId;
    }

    // @Override
    // public void displayDashboard(User loggedInUser) {
    // System.out.print("\033[H\033[2J");
    // System.out.println("Hello");
    // }

    // @Override
    // public void addCourse() {
    // System.out.println("admin add course is working...");
    // }

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
    public void addCourse(Course selectedCourse, User loggedInUser) {
        System.out.println("working");
    }

    @Override
    public void unregisteredFromCourse(Course course, User loggedInUser) {
        System.out.println("unregisteredFromCourse admin is working...");

    }

}
