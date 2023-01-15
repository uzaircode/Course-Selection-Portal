import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Registration {

        String username, password, emailAddress;
        int phoneNumber, studentId;

        AddressInfo theAddress = new AddressInfo();
        Student stud1 = new Student(username, password, emailAddress, phoneNumber, theAddress);

        public void displayLogin() {
                try (Scanner scan = new Scanner(new File("output.txt"))) {
                        Scanner keyboard = new Scanner(System.in);
                        String user = scan.nextLine();
                        String pass = scan.nextLine(); // looks at selected file in scan

                        System.out.print("Enter username: ");
                        String inpUser = keyboard.nextLine();
                        System.out.print("Enter password: ");
                        String inpPass = keyboard.nextLine(); // gets input from user

                        if (inpUser.equals(user) && inpPass.equals(pass)) {
                                System.out.print("Correct");
                                // menu();
                        } else {
                                System.out.print("Incorrect");
                        }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }

        public void displayRegister() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {
                        try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

                                System.out.println("===== REGISTER =====");
                                System.out.print("Enter username: ");

                                username = input.nextLine();
                                stud1.setUsername(username);
                                writer.write("\n" + username);

                                System.out.print("Enter password: ");
                                password = input.nextLine();
                                stud1.setPassword(password);
                                writer.write("\n" + password);

                                System.out.print("Enter email address: ");
                                emailAddress = input.nextLine();
                                stud1.setEmailAddress(emailAddress);
                                writer.write("\n" + emailAddress);

                                System.out.print("Enter phone number: ");
                                phoneNumber = Integer.parseInt(input.nextLine());
                                stud1.setPhoneNumber(phoneNumber);
                                writer.write("\n" + phoneNumber);

                                stud1.setStudentId(studentId);
                                writer.write("\n" + studentId);

                                System.out.print("Enter street: ");
                                String street = input.nextLine();
                                theAddress.setStreet(street);
                                writer.write("\n" + street);

                                System.out.print("Enter city: ");
                                String city = input.nextLine();
                                theAddress.setCity(city);
                                writer.write("\n" + city);

                                System.out.print("Enter state: ");
                                String state = input.nextLine();
                                theAddress.setState(state);
                                writer.write("\n" + state);

                                System.out.print("Enter postalCode: ");
                                String postalCode = input.nextLine();
                                theAddress.setPostalCode(postalCode);
                                writer.write("\n" + postalCode);

                                System.out.print("Enter country: ");
                                String country = input.nextLine();
                                theAddress.setCountry(country);
                                writer.write("\n" + country);

                                writer.close();

                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                } catch (NumberFormatException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

        public void displayOption() {
                Scanner input = new Scanner(System.in);

                System.out.println("(1) LOGIN");
                System.out.println("(2) REGISTER");

                System.out.print("\nChoose 1 : ");
                int selection = input.nextInt();
                if (selection == 1) {
                        displayLogin();
                } else if (selection == 2) {
                        displayRegister();
                }
        }

        public void menu() {

                displayOption();

                // System.out.print("\033[H\033[2J");
                // System.out.println("===== STUDENT INFORMATION =====");
                // System.out.println("Student Name : " + stud1.getUsername());
                // System.out.println("Password : " + stud1.getPassword());
                // System.out.println("Student ID : " + stud1.getStudentId());
                // System.out.println("Email Address : " + stud1.getEmailAddress());
                // System.out.println("Phone Number : " + stud1.getPhoneNumber());
                // System.out.println("Faculty : " + stud1.getFaculty());
                // System.out.println("Home Address : " + stud1.getAddressInfo().toString() +
                // "\n\n");

                // System.out.println("===== DASHBOARD =====");
                // System.out.println("Welcome " + stud1.getUsername() + "!");
                // System.out.println("\n1. COURSE ENROLLMENT");
                // System.out.print("\nChoose 1 : ");

                // Course c = new Course();

                // c.displayCourseList();
        }
}
