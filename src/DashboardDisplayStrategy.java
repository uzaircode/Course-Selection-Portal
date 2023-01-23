// implement Interface Segregation Principle (ISP) as both dashboard implement the method.
public interface DashboardDisplayStrategy {
    void userDisplayPortal();

    void displayLogin();

    void displayRegister();

}