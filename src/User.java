public abstract class User {
    private String username;
    private String password;
    private String emailAddress;
    private int phoneNumber;
    private AddressInfo addressInfo; // Composition

    public User(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.addressInfo = addressInfo;
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    abstract void displayInformation(User loggedInUser);

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

}
