import java.util.*;

public class Registration {

    String username;
    String password;
    Student stud1 = new Student(username, password, 1201200657, MediumStudy.UNDERGRADUATE);

    public void displayLogin() {
        Scanner input = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.print("Enter username: ");
        username = input.nextLine();
        stud1.setUsername(username);
        System.out.print("Enter password: ");
        password = input.nextLine();
        stud1.setPassword(password);
    }

    // public void displayRegister() {
    // // String username;
    // // String password;
    // // Scanner input = new Scanner(System.in);

    // // System.out.println("===== REGISTER =====");
    // // System.out.print("Enter username: ");
    // // username = input.nextLine();
    // // stud1.setUsername(username);

    // // System.out.print("Enter password: ");
    // // password = input.nextLine();
    // // stud1.setPassword(password);
    // }

    public void menu() {
        Scanner input = new Scanner(System.in);
        Course res = new Course(password, password, 0, 0, MediumStudy.FOUNDATION);

        System.out.print("\033[H\033[2J");
        System.out.println("===== STUDENT INFORMATION");
        System.out.println("Student Name : " + stud1.getUsername());
        System.out.println("Password     : " + stud1.getPassword());
        System.out.println("Student ID   : " + stud1.getStudentId() + "\n\n");

        System.out.println("===== DASHBOARD =====");
        System.out.println("Welcome " + stud1.getUsername() + "!");
        System.out.println("\n1. COURSE ENROLLMENT");
        System.out.print("\nChoose 1 : ");
        int choice = input.nextInt();

        if (choice == 1)
            res.displayCourseList();
    }
}
