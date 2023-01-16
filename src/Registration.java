import java.util.*;

public class Registration {

        String username, password, emailAddress;
        int phoneNumber, studentId;

        AddressInfo theAddress = new AddressInfo();
        List<Student> listOfUsers = new ArrayList<>();
        User loggedInUser = null;

        public void displayLogin() {
                System.out.print("\033[H\033[2J");

                // listOfUsers.add(new Student("user2", "password2"));
                // listOfUsers.add(new Student("user3", "password3"));

                try (Scanner keyboard = new Scanner(System.in)) {
                        System.out.print("Enter username: ");
                        String inpUser = keyboard.nextLine();
                        System.out.print("Enter password: ");
                        String inpPass = keyboard.nextLine(); // gets input from user

                        for (Student user : listOfUsers) {
                                if (user.getUsername().equals(inpUser)) {
                                        if (user.getPassword().equals(inpPass)) {
                                                loggedInUser = user;
                                                // when a user is found, "break" stops iterating through the
                                                // list
                                                dashboard();
                                        }
                                }
                        }

                        // if loggedInUser was changed from null, it was successful
                        if (loggedInUser != null) {
                                dashboard();
                        } else {
                                System.out.println("Invalid username/password combination\n");
                                displayLogin();
                        }

                        // while (scan.hasNext()) {
                        // String user = scan.nextLine();
                        // String pass = scan.nextLine();

                        // if (inpUser.equals(user) && inpPass.equals(pass)) {
                        // // System.out.print("Correct");
                        // dashboard();
                        // } else {
                        // System.out.print("Incorrect");
                        // }
                        // }
                }
        }

        public void displayRegister() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {

                        System.out.println("===== REGISTER =====");
                        System.out.print("Enter username: ");
                        String username = input.nextLine();

                        System.out.print("Enter password: ");
                        password = input.nextLine();

                        System.out.print("Enter email address: ");
                        emailAddress = input.nextLine();

                        System.out.print("Enter phone number: ");
                        phoneNumber = Integer.parseInt(input.nextLine());

                        // stud1.setStudentId(studentId);

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

                        listOfUsers.add(new Student(username, password, emailAddress, phoneNumber,
                                        studentId, theAddress, null,
                                        emailAddress));

                        displayOption();
                } catch (NumberFormatException e) {
                        e.printStackTrace();
                }
        }

        public void displayOption() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {
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
        }

        public void dashboard() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {
                        System.out.println("===== DASHBOARD =====");
                        System.out.println("Welcome " + loggedInUser.getUsername() + "!");
                        System.out.println("\n1. STUDENT INFORMATION");
                        System.out.println("2. COURSE ENROLLMENT");
                        System.out.println("3. LOGOUT");

                        System.out.print("\nChoose 1 : ");
                        int selection = input.nextInt();
                        if (selection == 1) {
                                userInformation();
                        } else if (selection == 2) {
                                displayCourseList();
                        } else if (selection == 3) {
                                displayOption();
                        }
                }

        }

        public void userInformation() {
                try (Scanner input = new Scanner(System.in)) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("===== STUDENT INFORMATION =====");
                        System.out.println("Student Name : " + loggedInUser.getUsername());
                        System.out.println("Password : " + loggedInUser.getPassword());
                        System.out.println("Student ID : ");
                        // System.out.println("Student ID : " + loggedInUser.getStudentId());
                        System.out.println("Email Address : " + loggedInUser.getEmailAddress());
                        System.out.println("Phone Number : " + loggedInUser.getPhoneNumber());
                        System.out.println("Student ID : ");
                        // System.out.println("Faculty : " + loggedInUser.getFaculty());
                        System.out.println("Home Address : " + loggedInUser.getAddressInfo().toString() +
                                        "\n\n");

                        System.out.print("\nPress 0 to return : ");
                        int selection = input.nextInt();
                        if (selection == 0)
                                dashboard();
                }

        }

        public void displayCourseList() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {
                        Course c = new Course();

                        c.displayCourseList();

                        System.out.print("\nPress 0 to return : ");
                        int selection = input.nextInt();
                        if (selection == 0)
                                dashboard();
                }
        }
}
