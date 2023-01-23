// The User class serves as an abstract base class for different types of users (e.g. Admin, Student) in the system.
// It contains common properties and methods that are shared among all user types.
public abstract class User {
    private String username;
    private String password;
    private String emailAddress;
    private int phoneNumber;
    private AddressInfo addressInfo;

    public User(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.addressInfo = addressInfo;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    abstract void displayUserDashboard(User loggedInUser);

    abstract void displayInformation(User loggedInUser);

    public void userLogout(User loggedInUser) {
        System.out.println("User " + loggedInUser.getUsername() + " has been logout.");
        loggedInUser = null;
        Main.main(null);
    }

}
