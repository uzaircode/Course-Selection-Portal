import java.util.*;

public abstract class User {
    private String username;
    private String password;
    private String emailAddress;
    private int phoneNumber;
    private AddressInfo homeAddress; // Composition

    public User(String username, String password, String emailAddress, int phoneNumber, AddressInfo homeAddress) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
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

    public AddressInfo getHomeAddress() {
        return homeAddress;
    }

    public void SetHomeAddress(AddressInfo homeAddress) {
        this.homeAddress = homeAddress;
    }

}
