// implement Interface Segregation Principle (ISP) as both dashboard implement the method.
// POLYMORPHISM is implemented which admin and student have a different implementation of the same method.

public interface DashboardDisplayStrategy {
    void displayUserPortal();

    void displayUserLogin();

    void displayUserRegister();

}