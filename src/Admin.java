public class Admin extends User implements Dashboard {
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

    @Override
    public void displayDashboard(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        System.out.println("Hello");
    }

}
