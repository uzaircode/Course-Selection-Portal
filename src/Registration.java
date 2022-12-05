import java.util.*;

public class Registration {

    String username;
    String password;
    Student stud1 = new Student("Uzair", "28424284247", "nikuzairsc@gmail.com",
            189002414, 1201200657,
            MediumStudy.UNDERGRADUATE, "Faculty of Computing & Informatics (FCI)");

    Professor prof1 = new Professor("Dina", "12932938", "dinasorous@gmail.com", 173842931, 82424747,
            "Faculty of Computing & Informatics (FCI)");
    Administrator admin1 = new Administrator("Lisa", "384849394", "liasssanao@gmail.com", 163774928, 238328382);

    // public void displayLogin() {
    // Scanner input = new Scanner(System.in);

    // System.out.println("===== LOGIN =====");
    // System.out.print("Enter username: ");
    // username = input.nextLine();
    // stud1.setUsername(username);
    // System.out.print("Enter password: ");
    // password = input.nextLine();
    // stud1.setPassword(password);
    // }

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
        System.out.println("===== STUDENT INFORMATION =====");
        System.out.println("Student Name     : " + stud1.getUsername());
        System.out.println("Password         : " + stud1.getPassword());
        System.out.println("Student ID       : " + stud1.getStudentId());
        System.out.println("Email Address    : " + stud1.getEmailAddress());
        System.out.println("Phone Number     : " + stud1.getPhoneNumber());
        System.out.println("Faculty          : " + stud1.getFaculty() + "\n\n");

        System.out.println("===== PROFESSOR INFORMATION =====");
        System.out.println("Professor Name     : " + prof1.getUsername());
        System.out.println("Password           : " + prof1.getPassword());
        System.out.println("Professor ID       : " + prof1.getProfessorId());
        System.out.println("Email Address      : " + prof1.getEmailAddress());
        System.out.println("Phone Number       : " + prof1.getPhoneNumber());
        System.out.println("Faculty            : " + prof1.getFaculty() + "\n\n");

        System.out.println("===== ADMINISTRATOR INFORMATION =====");
        System.out.println("Administrator Name   : " + admin1.getUsername());
        System.out.println("Password             : " + admin1.getPassword());
        System.out.println("Administrator ID     : " + admin1.getAdministratorId());
        System.out.println("Email Address        : " + admin1.getEmailAddress());
        System.out.println("Phone Number         : " + admin1.getPhoneNumber() + "\n\n");

        System.out.println("===== DASHBOARD =====");
        System.out.println("Welcome " + stud1.getUsername() + "!");
        System.out.println("\n1. COURSE ENROLLMENT");
        System.out.print("\nChoose 1 : ");
        int choice = input.nextInt();

        if (choice == 1)
            res.displayCourseList();
    }
}
