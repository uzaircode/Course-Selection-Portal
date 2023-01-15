import java.util.*;

public class Registration {

        String username, password, emailAddress;
        int phoneNumber, studentId;

        AddressInfo theAddress = new AddressInfo();
        Student stud1 = new Student(username, password, emailAddress, phoneNumber, theAddress);

        public void displayRegister() {
                Scanner input = new Scanner(System.in);

                System.out.println("===== REGISTER =====");
                System.out.print("Enter username: ");
                username = input.nextLine();
                stud1.setUsername(username);

                System.out.print("Enter password: ");
                password = input.nextLine();
                stud1.setPassword(password);

                System.out.print("Enter email address: ");
                emailAddress = input.nextLine();
                stud1.setEmailAddress(emailAddress);

                System.out.print("Enter phone number: ");
                phoneNumber = Integer.parseInt(input.nextLine());
                stud1.setPhoneNumber(phoneNumber);

                stud1.setStudentId(studentId);

                System.out.print("Enter street: ");
                String street = input.nextLine();
                theAddress.setStreet(street);

                System.out.print("Enter city: ");
                String city = input.nextLine();
                theAddress.setCity(city);

                System.out.print("Enter state: ");
                String state = input.nextLine();
                theAddress.setState(state);

                System.out.print("Enter postalCode: ");
                String postalCode = input.nextLine();
                theAddress.setPostalCode(postalCode);

                System.out.print("Enter country: ");
                String country = input.nextLine();
                theAddress.setCountry(country);
        }

        public void menu() {
                displayRegister();

                System.out.print("\033[H\033[2J");
                System.out.println("===== STUDENT INFORMATION =====");
                System.out.println("Student Name : " + stud1.getUsername());
                System.out.println("Password : " + stud1.getPassword());
                System.out.println("Student ID : " + stud1.getStudentId());
                System.out.println("Email Address : " + stud1.getEmailAddress());
                System.out.println("Phone Number : " + stud1.getPhoneNumber());
                System.out.println("Faculty : " + stud1.getFaculty());
                System.out.println("Home Address : " + stud1.getAddressInfo().toString() +
                                "\n\n");

                System.out.println("===== DASHBOARD =====");
                System.out.println("Welcome " + stud1.getUsername() + "!");
                System.out.println("\n1. COURSE ENROLLMENT");
                System.out.print("\nChoose 1 : ");

                Course c = new Course();

                c.displayCourseList();
        }
}
