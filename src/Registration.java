import java.util.*;

public class Registration {

    public void displayLogin() {
        String username;
        String password;

        Scanner input = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.print("Enter username: ");
        username = input.nextLine();
        System.out.print("Enter password: ");
        password = input.nextLine();

        User user = new User(username, password);
    }

    public void displayRegister() {
        String username;
        String password;
        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTER =====");
        System.out.print("Enter username: ");
        username = input.nextLine();
        // stud.setUsername(username);

        System.out.print("Enter password: ");
        password = input.nextLine();
        // stud.setPassword(password);
    }

    public void menu() {
        System.out.print("\033[H\033[2J");
        System.out.println("===== DASHBOARD =====");
        // System.out.println("Welcome " + stud.getUsername() + "!");
        // System.out.println("Student Id: " + stud.getStudentId());
        System.out.println("\n1. STUDENT INFORMATION");
        System.out.println("2. COURSE ENROLLMENT");
    }
}
