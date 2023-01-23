// implement Interface Segregation Principle (ISP) as both dashboard implement the method.
// For more detailed information, please refer to the documentation report.

public interface DashboardDisplayStrategy {
    void userDisplayPortal();

    void displayLogin();

    void displayRegister();

}