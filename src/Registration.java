import java.util.*;

public class Registration {

        String username, password, emailAddress;
        int phoneNumber, studentId;

        AddressInfo theAddress = new AddressInfo();
        List<Student> listOfUsers = new ArrayList<>();
        Student loggedInUser = null;
        Scanner input = new Scanner(System.in);

        // Student student = new Student("JohnDoe", 12345);
        Course course = new Course("ODN3329", "Foundation in Arts ",
                        new String[] { "Data Structures", "Algorithms", "Programming Languages" },
                        120,
                        new String[] { "Masters in Computer Science",
                                        "MBA in IT" },
                        new String[] { "hello" },
                        true, 14, 120, MediumOfStudy.FOUNDATION);

        public void displayLogin() {
                System.out.print("\033[H\033[2J");

                listOfUsers.add(new Student("uzair", "123"));

                System.out.print("Enter username: ");
                String inpUser = input.nextLine();
                System.out.print("Enter password: ");
                String inpPass = input.nextLine(); // gets input from user

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

        public void dashboard() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== DASHBOARD =====");
                System.out.println("Welcome " + loggedInUser.getUsername() + "!");

                System.out.println("\n1. MANAGE PERSONAL INFORMATION");
                System.out.println("2. VIEW ACADEMIC CREDENTIALS");
                System.out.println("3. VIEW AVAILABLE COURSES");
                System.out.println("4. VIEW SELECTED COURSES");
                System.out.println("5. VIEW VIDEO BRIEFINGS");
                System.out.println("6. LOGOUT");

                System.out.print("\nChoose 1 : ");

                int choice = 0;
                try {
                        choice = input.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number.");
                        dashboard();
                        return;
                }

                switch (choice) {
                        case 1:
                                userInformation();
                                break;
                        case 2:
                                academicCredential();
                                break;
                        case 3:
                                displayCourseOffered();
                                break;
                        case 4:
                                displaySelectedCourse();
                                break;
                        default:
                                System.out.println("Invalid option, please try again.");
                                dashboard();
                                return;
                }

        }

        public void userInformation() {
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

        public void academicCredential() {

        }

        public void displayCourseOffered() {
                System.out.print("\033[H\033[2J");
                System.out.println("===== COURSE SELECTION =====");
                // display all available course
                Course courseList = new Course();
                List<Course> courses = courseList.getAllCourses();

                for (Course course : courses) {
                        System.out.println("Name : " + course.getCourseName());
                }

                System.out.println("\n\n(1) ADD COURSE");
                System.out.println("(2) DELETE COURSE");
                System.out.println("(3) RETURN TO DASHBOARD");

                System.out.print("\nChoose 1 : ");
                int selection = input.nextInt();
                if (selection == 1) {
                        displayCourseSelection();
                } else if (selection == 2) {
                        unregisterFromCourse();
                } else if (selection == 3) {
                        dashboard();
                }

                System.out.print("\nChoose 1 : ");

                int choice = 0;
                try {
                        choice = input.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number.");
                        dashboard();
                        return;
                }

                switch (choice) {
                        case 1:
                                displayCourseSelection();
                                break;
                        case 2:
                                unregisterFromCourse();
                                break;
                        case 3:
                                dashboard();
                                break;
                        default:
                                System.out.println("Invalid option, please try again.");
                                dashboard();
                                return;
                }

        }

        public void displayCourseSelection() {
                System.out.print("\033[H\033[2J");
                System.out.println("Select a course to register for:");
                Course courseList = new Course();
                List<Course> availableCourses = courseList.getAllCourses();
                int i = 1;
                for (Course course : availableCourses) {
                        System.out.println(i + ". " + course.getCourseName());
                        i++;
                }
                int choice = input.nextInt();
                Course selectedCourse = availableCourses.get(choice - 1);
                loggedInUser.addCourse(selectedCourse);

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                        dashboard();
        }

        public void unregisterFromCourse() {
                System.out.print("\033[H\033[2J");
                System.out.println("=====  UNREGISTERED COURSES =====");

                List<Course> registeredCourses = loggedInUser.getCourses();
                if (registeredCourses.isEmpty()) {
                        System.out.println("You haven't registered for any courses yet.");
                        return;
                }

                System.out.println("Select a course to unregister from :");
                for (int i = 0; i < registeredCourses.size(); i++) {
                        System.out.println((i + 1) + ". " + registeredCourses.get(i).getCourseName());
                }

                try (Scanner input = new Scanner(System.in)) {
                        int choice = 0;
                        choice = input.nextInt();
                        if (choice > 0 && choice <= registeredCourses.size()) {
                                Course courseToUnregister = registeredCourses.get(choice - 1);
                                loggedInUser.removeCourse(courseToUnregister);
                                System.out.println("You have been unregistered from "
                                                + courseToUnregister.getCourseName());
                                System.out.print("\nPress 0 to return : ");
                                int selection = input.nextInt();
                                if (selection == 0)
                                        dashboard();
                        } else {
                                System.out.println("Invalid choice.");
                        }
                }

        }

        public void displaySelectedCourse() {
                System.out.print("\033[H\033[2J");
                System.out.println("=====  REGISTERED COURSES =====");
                List<Course> studentCourses = loggedInUser.getCourses();
                Course.printCourses(studentCourses);

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                        dashboard();

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

}
