import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            DashboardDisplayStrategy strategy = null;

            System.out.print("\033[H\033[2J");
            System.out.println("===== WELCOME TO MMU PORTAL =====");
            System.out.println("\n(1) VIEW ALL COURSES ");
            System.out.println("(2) VIEW COURSE BRIEFING");
            System.out.println("\n(3) STUDENT PORTAL");
            System.out.println("(4) ADMIN PORTAL");
            System.out.println("\n(5) EXIT PORTAL");

            System.out.print("\nChoose 1 : ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    viewAllCourses();
                    break;
                case 2:
                    viewCourseBriefing();
                    break;
                case 3:
                    /*
                     * The StudentDashboardDisplayStrategy class is assigned to the 'strategy'
                     * variable. This will direct the program to display the student dashboard to
                     * the user.
                     */
                    strategy = new StudentDashboardDisplayStrategy();
                    break;
                case 4:
                    /*
                     * The AdminDashboardDisplayStrategy class is assigned to the
                     * 'strategy'variable. This will direct the program to display the admin
                     * dashboard to the user.
                     */
                    strategy = new AdminDashboardDisplayStrategy();
                    break;
                case 5:
                    return;
            }
            if (strategy != null) {
                strategy.displayUserPortal();
            }
        }
    }

    public static void viewCourseBriefing() {
        System.out.print("\033[H\033[2J");
        System.out.println("===== COURSE BRIEFING VIDEO =====");
        System.out.println("\nDisplay course briefing...");

        System.out.print("\nPress 0 to return : ");
        int selection = input.nextInt();
        if (selection == 0)
            return;
    }

    public static void viewAllCourses() {

        System.out.print("\033[H\033[2J");
        System.out.println("===== BROWSE THE PROGRAMMES =====\n");

        Course course = new Course();
        course.displayAllCourse();

        System.out.print("\nPress 0 to return : ");
        int selection = input.nextInt();
        if (selection == 0)
            return;

    }
}
