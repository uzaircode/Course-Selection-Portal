import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Registration res = new Registration();
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("\033[H\033[2J");
            System.out.println("===== MULTIMEDIA UNVERSITY =====");
            System.out.println("\n(1) STUDENT PORTAL");
            System.out.println("(2) ADMIN PORTAL");
            System.out.println("(3) MMU PORTAL");

            System.out.print("\nChoose 1 : ");
            int selection = input.nextInt();
            if (selection == 1) {
                res.displayStudentPortal();
            } else if (selection == 2) {
                // adminPortal
            } else if (selection == 3) {
                // mmuPortal
            }
        }

    }
}
