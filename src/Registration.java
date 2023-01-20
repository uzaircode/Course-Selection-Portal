import java.util.*;

public class Registration {

        String username, password, emailAddress;
        int phoneNumber;

        AddressInfo theAddress = new AddressInfo();
        List<User> listOfUsers = new ArrayList<>();
        User loggedInUser = null;
        Course selectedCourse = new Course();
        Scanner input = new Scanner(System.in);

        public void displayStudentPortal() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== WELCOME TO STUDENT PORTAL =====");
                System.out.println("\n(1) LOGIN");
                System.out.println("(2) REGISTER");

                System.out.print("\nChoose 1 : ");
                int selection = input.nextInt();
                if (selection == 1) {
                        displayLogin();
                } else if (selection == 2) {
                        displayRegister();
                }
        }

        public void displayAdminPortal() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== WELCOME TO ADMIN PORTAL =====");
                System.out.println("\n(1) LOGIN");
                System.out.println("(2) REGISTER");

                System.out.print("\nChoose 1 : ");
                int selection = input.nextInt();
                if (selection == 1) {
                        displayLogin();
                } else if (selection == 2) {
                        displayRegister();
                }
        }

        public void displayLogin() {
                System.out.print("\033[H\033[2J");

                listOfUsers.add(new Student("uzair", "123"));
                listOfUsers.add(new Admin("dina", "123"));

                try (Scanner input = new Scanner(System.in)) {
                        System.out.println("===== USER LOGIN =====");
                        System.out.print("\nEnter username: ");
                        String inpUser = input.nextLine();
                        System.out.print("Enter password: ");
                        String inpPass = input.nextLine();

                        // check if student is exist
                        for (User user : listOfUsers) {
                                if (user.getUsername().equals(inpUser)) {
                                        if (user.getPassword().equals(inpPass)) {
                                                loggedInUser = user;
                                                // check if loggedInUser is instance of Student or Admin
                                                if (loggedInUser instanceof Student) {
                                                        studentDashboard(loggedInUser);
                                                } else if (loggedInUser instanceof Admin) {
                                                        adminDashboard(loggedInUser);
                                                }
                                                break;
                                        }
                                }
                        }
                        if (loggedInUser == null) {
                                System.out.println("Invalid username/password combination\n");
                        }

                }
        }

        public void displayRegister() {
                System.out.print("\033[H\033[2J");
                try (Scanner input = new Scanner(System.in)) {

                        System.out.println("===== STUDENT REGISTRATION =====");
                        System.out.print("\nEnter username      : ");
                        String username = input.nextLine();

                        System.out.print("Enter password      : ");
                        password = input.nextLine();

                        System.out.print("Enter email address : ");
                        emailAddress = input.nextLine();

                        System.out.print("Enter phone number  : ");
                        phoneNumber = Integer.parseInt(input.nextLine());

                        System.out.println("\n===== ADDRESS INFORMATION =====");
                        System.out.print("\nEnter street     : ");
                        String street = input.nextLine();
                        theAddress.setStreet(street);

                        System.out.print("Enter city       : ");
                        String city = input.nextLine();
                        theAddress.setCity(city);

                        System.out.print("Enter state      : ");
                        String state = input.nextLine();
                        theAddress.setState(state);

                        System.out.print("Enter postalCode : ");
                        String postalCode = input.nextLine();
                        theAddress.setPostalCode(postalCode);

                        System.out.print("Enter country    : ");
                        String country = input.nextLine();
                        theAddress.setCountry(country);

                        Student newStudent = new Student(username, password, emailAddress, phoneNumber, theAddress,
                                        null,
                                        emailAddress);
                        listOfUsers.add(newStudent);

                        displayStudentPortal();
                } catch (NumberFormatException e) {
                        e.printStackTrace();
                }
        }

        public void studentDashboard(User loggedInUser) {
                System.out.print("\033[H\033[2J");
                System.out.println("===== STUDENT DASHBOARD =====");
                System.out.println("Welcome " + loggedInUser.getUsername() + "!");

                System.out.println("\n1. MANAGE PERSONAL INFORMATION");
                System.out.println("2. VIEW ACADEMIC CREDENTIALS");
                System.out.println("3. VIEW AVAILABLE COURSES");
                System.out.println("4. VIEW SELECTED COURSES");
                System.out.println("5. LOGOUT");

                System.out.print("\nChoose 1 : ");

                int choice = 0;
                try {
                        choice = input.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number.");
                        return;
                }

                switch (choice) {
                        case 1:
                                userInformation(loggedInUser);
                                break;
                        case 2:
                                // academicCredential();
                                break;
                        case 3:
                                manageCourse(loggedInUser);
                                break;
                        case 4:
                                displaySelectedCourse(loggedInUser);
                                break;
                        case 5:
                                logout(loggedInUser);
                                break;
                        default:
                                System.out.println("Invalid option, please try again.");
                                studentDashboard(loggedInUser);
                                return;
                }

        }

        public void adminDashboard(User loggedInUser) {
                System.out.print("\033[H\033[2J");
                System.out.println("===== ADMIN DASHBOARD =====");
                System.out.println("Welcome " + loggedInUser.getUsername() + "!");

                System.out.println("\n1. MANAGE PERSONAL INFORMATION");
                System.out.println("2. VIEW STUDENT LIST");
                System.out.println("3. MANAGE COURSES");
                System.out.println("4. LOGOUT");

                System.out.print("\nChoose 1 : ");

                int choice = 0;
                try {
                        choice = input.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number.");
                        return;
                }

                switch (choice) {
                        case 1:
                                userInformation(loggedInUser);
                                break;
                        case 2:
                                // view student list;
                                break;
                        case 3:
                                manageCourse(loggedInUser);
                                break;
                        case 4:
                                logout(loggedInUser);
                                break;
                        default:
                                System.out.println("Invalid option, please try again.");
                                adminDashboard(loggedInUser);
                                return;
                }
        }

        public void userInformation(User loggedInUser) {
                loggedInUser.displayInformation(loggedInUser);
        }

        public void manageCourse(User loggedInUser) {

                if (loggedInUser instanceof Student) {
                        ((Student) loggedInUser).manageCourse(selectedCourse, loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                        ((Admin) loggedInUser).manageCourse(selectedCourse, loggedInUser);
                }
        }

        public void displayAddCourses(Course selectedCourse, User loggedInUser) {
                if (loggedInUser instanceof Student) {
                        ((Student) loggedInUser).displayAddCourses(selectedCourse, loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                        ((Admin) loggedInUser).displayAddCourses(selectedCourse, loggedInUser);
                }
        }

        public void unregisterFromCourse(User loggedInUser) {
                if (loggedInUser instanceof Student) {
                        ((Student) loggedInUser).unregisteredFromCourse(selectedCourse, loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                        ((Admin) loggedInUser).unregisteredFromCourse(selectedCourse, loggedInUser);
                }
        }

        public void displaySelectedCourse(User loggedInUser) {

                if (loggedInUser instanceof Student) {
                        ((Student) loggedInUser).printRegisteredCourses(loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                        // ((Admin) loggedInUser).printAllCourse();
                }
        }

        // public void displayAcademicCredentials() {
        // if (loggedInUser != null) {
        // System.out.println("Academic Credentials for " + loggedInUser.getUsername() +
        // ":");
        // System.out.println("Degree: " + loggedInUser.getDegree());
        // System.out.println("Major: " + loggedInUser.getMajor());
        // System.out.println("GPA: " + loggedInUser.getGpa());
        // } else {
        // System.out.println("You must be logged in to view your academic
        // credentials.");
        // }
        // }

        public void logout(User loggedInUser) {
                System.out.println("User " + loggedInUser.getUsername() + " has been logout.");
                loggedInUser = null;
                displayStudentPortal();
        }

        public void displayMMUPortal() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== WELCOME TO MMU PORTAL =====");
                System.out.println("\n(1) VIEW ALL COURSES ");
                System.out.println("(2) VIEW COURSE BRIEFING");

                System.out.print("\nChoose 1 : ");
                int selection = input.nextInt();
                if (selection == 1) {
                        viewAllCourses();
                } else if (selection == 2) {
                        viewCourseBriefing();
                }
        }

        public void viewCourseBriefing() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== COURSE BRIEFING VIDEO =====");
                System.out.println("\nDisplay course briefing...");

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                        displayMMUPortal();
        }

        public void viewAllCourses() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== BROWSE THE PROGRAMMES =====\n");
                Course courseList = new Course();
                List<Course> courses = courseList.getAllCourses();

                int i = 1;
                for (Course course : courses) {
                        System.out.println("(" + i + ") " + course.getCourseName());
                        i++;
                }

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                        displayMMUPortal();

        }

}
