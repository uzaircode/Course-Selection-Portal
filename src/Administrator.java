public class Administrator extends User {
    private int administratorId;

    public Administrator(String username, String password, String emailAddress, int phoneNumber, int administratorId,
            AddressInfo addressInfo) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.administratorId = administratorId;
    }

    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
    }
}
