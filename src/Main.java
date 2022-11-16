import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        User user = new User();

        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("=====MAIN MENU=====");
        System.out.println("1. Login");
        System.out.println("2. Register");

        System.out.print("Pick 1 : ");
        choice = input.nextInt();

        if(choice == 1) {
            System.out.print("\033[H\033[2J");
            user.displayLogin();
            user.menu();
        } else if(choice == 2){
            System.out.print("\033[H\033[2J");
            user.displayRegister();
            user.menu();
        }
    }
}
