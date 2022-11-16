import java.util.*;

public class User {
    Student stud = new Student();

    public void displayLogin() {
        String username;
        String password;

        Scanner input = new Scanner(System.in);

        System.out.println("=====LOGIN=====");
        System.out.print("Enter username: ");
        username = input.nextLine();
        System.out.print("Enter password: ");
        password = input.nextLine();
    }

    public void displayRegister() {
        String username;
        String password;
        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTER =====");
        System.out.print("Enter username: ");
        username = input.nextLine();
        stud.setUsername(username);

        System.out.print("Enter password: ");
        password = input.nextLine();
        stud.setPassword(password);

        stud.setStudentId(11);
    }

    public void menu() {
        System.out.print("\033[H\033[2J");
        System.out.println("===== DASHBOARD =====");
        System.out.println("Welcome " + stud.getUsername() + "!");
        System.out.println("Student Id: " + stud.getStudentId());
    }
}
