import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements ICourseOperation {
    private String adminId;
    Scanner input = new Scanner(System.in);

    public Admin(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo,
            String adminId) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    public void addOfferedCourse(Course selectedCourse, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== CREATE NEW COURSE =====\n");

            System.out.print("Enter course name : ");
            String name = input.nextLine();

            System.out.print("Enter course id : ");
            String id = input.nextLine();

            System.out.print("Enter subjects taught (separated by commas) : ");
            String[] subjects = input.nextLine().split(",");

            System.out.print("Enter course duration: ");
            int duration = input.nextInt();
            input.nextLine(); // consume the remaining newline character

            System.out.print("Enter employment opportunities (separated by commas) : ");
            String[] employmentOpportunities = input.nextLine().split(",");

            System.out.print("Enter scope for further studies (separated by commas) : ");
            String[] scopeForFurtherStudies = input.nextLine().split(",");

            System.out.print("Does the course offer scholarship facilities? (true/false) ");
            boolean scholarshipFacilities = input.nextBoolean();

            System.out.print("Enter fee structure : ");
            int feeStructure = input.nextInt();

            System.out.print("Enter maximum number of students : ");
            int maxStudents = input.nextInt();

            System.out.print("Enter medium of study (FOUNDATION, DIPLOMA, UNDERGRADUATE, POSTGRADUATE, PHD) : ");
            MediumOfStudy medium = MediumOfStudy.valueOf(input.next().toUpperCase());

            Course newCourse = new Course(id, name, subjects, duration, employmentOpportunities, scopeForFurtherStudies,
                    scholarshipFacilities, feeStructure, maxStudents, medium);
            Course.addCourse(newCourse);

            System.out.println("\nCourse " + newCourse.getCourseName() + " has been created successfully.");

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                manageCourse(selectedCourse, loggedInUser);
        } catch (

        NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    void displayInformation(User loggedInUser) {
        System.out.print("\033[H\033[2J");
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== ADMIN INFORMATION =====");
            System.out.println("Admin Name  : " + loggedInUser.getUsername());
            System.out.println("Password      : " + loggedInUser.getPassword());
            System.out.println("Admin ID    : " + ((Admin) loggedInUser).getAdminId());
            System.out.println("Email Address : " + loggedInUser.getEmailAddress());
            System.out.println("Phone Number  : " + loggedInUser.getPhoneNumber());
            // System.out.println("Faculty : " + loggedInUser.getFaculty());

            System.out.println("\n===== ADMIN ADDRESS INFORMATION =====");
            System.out.println("Street       : " + loggedInUser.getAddressInfo().getStreet());
            System.out.println("City         : " + loggedInUser.getAddressInfo().getCity());
            System.out.println("State        : " + loggedInUser.getAddressInfo().getState());
            System.out.println("Postal Code  : " + loggedInUser.getAddressInfo().getPostalCode());
            System.out.println("Country      : " + loggedInUser.getAddressInfo().getCountry());

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                adminStrategy.adminDashboard(loggedInUser);
        }
    }

    @Override
    public void removeOfferedCourse(Course c, User loggedInUser) {
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        List<Course> courses = Course.getAllCourses();

        System.out.print("\033[H\033[2J");
        System.out.println("Enter the name of the course to remove:");
        String courseName = input.nextLine();

        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                courses.remove(course);
                System.out.println("Course removed successfully");
                return;
            }
        }
        System.out.println("Course not found");

        System.out.print("\nPress 0 to return : ");
        int selection = input.nextInt();
        if (selection == 0)
            adminStrategy.adminDashboard(loggedInUser);
    }

    @Override
    public void manageCourse(Course selectedCourse, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            List<Course> allCourses = Course.getAllCourses();

            int i = 1;
            for (Course course : allCourses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.println("\n\n(1) ADD COURSE");
            System.out.println("(2) UPDATE COURSE");
            System.out.println("(3) DELETE COURSE");
            System.out.println("(4) RETURN TO DASHBOARD");

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
                    adminStrategy.displayAddOfferedCourses(selectedCourse, loggedInUser);
                    break;
                case 2:
                    adminStrategy.displayUpdateOfferedCourses(loggedInUser);
                    break;
                case 3:
                    adminStrategy.displayRemoveOfferedCourse(loggedInUser);
                    break;
                case 4:
                    adminStrategy.adminDashboard(loggedInUser);
                default:
                    System.out.println("Invalid option, please try again.");
                    // studStrategy.studentDashboard(loggedInUser);
                    return;
            }
        }
    }

    @Override
    public void updateOfferedCourse(Course selectedCourse, User loggedInUser) {
        System.out.print("\033[H\033[2J");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("===== UPDATE COURSE =====\n");

            System.out.println("Enter course name: ");
            String name = input.nextLine();

            System.out.println("Enter course id: ");
            String id = input.nextLine();

            List<Course> allCourses = Course.getAllCourses();

            for (Course course : allCourses) {
                if (course.getCourseName().equalsIgnoreCase(name) && course.getCourseId().equalsIgnoreCase(id)) {
                    System.out.println("Enter new course name: ");
                    course.setCourseName(input.nextLine());

                    System.out.println("Enter new course id: ");
                    course.setCourseId(input.nextLine());

                    System.out.println("Enter new subjects taught (separated by commas): ");
                    course.setSubjectTaught(input.nextLine().split(","));

                    System.out.println("Enter new course duration: ");
                    course.setCourseDuration(input.nextInt());
                    input.nextLine(); // consume the remaining newline character

                    System.out.println("Enter new employment opportunities (separated by commas): ");
                    course.setEmploymentOpportunities(input.nextLine().split(","));

                    System.out.println("Enter new scope for further studies (separated by commas): ");
                    course.setScopeForFutherStudies(input.nextLine().split(","));

                    System.out.println("Does the course offer scholarship facilities? (true/false) ");
                    course.setScholarshipFacilities(input.nextBoolean());

                    System.out.println("Enter new fee structure: ");
                    course.setFeeStructure(input.nextInt());

                    System.out.println("Enter new maximum number of students: ");
                    course.setMaximumStudent(input.nextInt());

                    System.out.println(
                            "Enter new medium of study (FOUNDATION, DIPLOMA, UNDERGRADUATE, POSTGRADUATE, PHD): ");
                    course.setMediumStudy(MediumOfStudy.valueOf(input.next().toUpperCase()));

                    System.out.println("\nCourse " + course.getCourseName() + " has been updated successfully.");

                    System.out.print("\nPress 0 to return : ");
                    int selection = input.nextInt();
                    if (selection == 0)
                        manageCourse(course, loggedInUser);
                    return;
                }
            }
            System.out.println("Course not found.");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
