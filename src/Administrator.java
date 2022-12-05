public class Administrator extends User {
    private int administratorId;

    public Administrator(String username, String password, String emailAddress, int phoneNumber, int administratorId) {
        super(username, password, emailAddress, phoneNumber);
        this.administratorId = administratorId;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }
}
