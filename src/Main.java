import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Registration res = new Registration();

        res.menu();
    }
}
