import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The CourseDelegation class implements the DELEGATION DESIGN PATTERN to separate the responsibilities of handling course add, remove, and update actions for Admin and Student users.
// This allows for a cleaner and more organized code structure, as well as the ability to easily add or modify functionality for specific user types in the future.
// Other developers should be aware of this structure and should utilize the delegation methods provided in this class when handling course actions for different user types.
public class CourseDelegation {
    private static Scanner input = new Scanner(System.in);

    public void handleCourseActions(User loggedInUser) {
        if (loggedInUser instanceof Admin) {
            System.out.print("\033[H\033[2J");
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
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

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid input, please enter a number.");
                return;
            }

            switch (choice) {
                case 1:
                    adminStrategy.addCourse(loggedInUser);
                    break;
                case 2:
                    adminStrategy.updateCourse(loggedInUser);
                    break;
                case 3:
                    adminStrategy.removeCourse(loggedInUser);
                    break;
                case 4:
                    adminStrategy.adminDashboard(loggedInUser);
                default:
                    System.out.println("Invalid option, please try again.");
                    adminStrategy.adminDashboard(loggedInUser);
                    return;
            }
        } else if (loggedInUser instanceof Student) {
            System.out.print("\033[H\033[2J");
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            List<Course> allCourses = Course.getAllCourses();

            int i = 1;
            for (Course course : allCourses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.println("\n\n(1) ADD COURSE");
            System.out.println("(2) DELETE COURSE");
            System.out.println("(3) RETURN TO DASHBOARD");

            System.out.print("\nChoose 1 : ");

            int choice = 0;

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // move this line here
            } else {
                System.out.println("Invalid input, please enter a number.");
                return;
            }

            switch (choice) {
                case 1:
                    studStrategy.addCourse(loggedInUser);
                    break;
                case 2:
                    studStrategy.removeCourse(loggedInUser);
                    break;
                case 3:
                    studStrategy.studentDashboard(loggedInUser);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    studStrategy.studentDashboard(loggedInUser);
                    return;
            }
        }
    }

    public void handleAddCourse(User loggedInUser, Course selectedCourse) {
        if (loggedInUser instanceof Admin) {
            // Admin implementation of adding a course
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
            System.out.print("\033[H\033[2J");
            System.out.println("===== CREATE NEW COURSE =====\n");

            System.out.print("Enter course name : ");
            String name = input.next();

            System.out.print("Enter course id : ");
            String id = input.next();

            System.out.print("Enter subjects taught (separated by commas) : ");
            String[] subjects = input.next().split(",");

            System.out.print("Enter course duration: ");
            int duration = input.nextInt();

            System.out.print("Enter employment opportunities (separated by commas) : ");
            String[] employmentOpportunities = input.next().split(",");

            System.out.print("Enter scope for further studies (separated by commas) : ");
            String[] scopeForFurtherStudies = input.next().split(",");

            System.out.print("Does the course offer scholarship facilities? (true/false) ");
            boolean scholarshipFacilities = input.nextBoolean();

            System.out.print("Enter fee structure : ");
            int feeStructure = input.nextInt();

            System.out.print("Enter maximum number of students : ");
            int maxStudents = input.nextInt();

            System.out.print("Enter medium of study (FOUNDATION, DIPLOMA, UNDERGRADUATE, POSTGRADUATE, PHD) : ");
            MediumOfStudy medium = MediumOfStudy.valueOf(input.next().toUpperCase());

            Course newCourse = new Course(id, name, subjects, duration, employmentOpportunities,
                    scopeForFurtherStudies,
                    scholarshipFacilities, feeStructure, maxStudents, medium);
            Course.addCourse(newCourse);

            System.out.println("\nCourse " + newCourse.getCourseName() + " has been created successfully.");

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                adminStrategy.manageCourse(loggedInUser);
        } else if (loggedInUser instanceof Student) {
            // Student implementation of adding a course
            System.out.print("\033[H\033[2J");
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();

            System.out.println("===== BROWSE THE PROGRAMMES =====\n");

            // display all available course
            List<Course> availableCourses = Course.getAllCourses();
            List<Course> studentCourses = ((Student) loggedInUser).getCourses();

            int i = 1;
            for (Course course : availableCourses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.print("\nSelect a course to register for : ");
            int choice = input.nextInt();

            selectedCourse = availableCourses.get(choice - 1);

            boolean isRegistered = false;
            for (Course c : studentCourses) {
                if (c.getCourseName().equalsIgnoreCase(selectedCourse.getCourseName())) {
                    isRegistered = true;
                    break;
                }
            }

            if (!isRegistered) {
                ((Student) loggedInUser).addCourses(selectedCourse);
                System.out.println("\nYou have been registered to " +
                        selectedCourse.getCourseName());
            } else {
                System.out.println("\nYou are already registered for " +
                        selectedCourse.getCourseName());
            }

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();
            if (selection == 0)
                studStrategy.manageCourse(loggedInUser);
        }
    }

    public void handleUpdateCourse(User user) {
        if (user instanceof Admin) {
            AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
            input = new Scanner(System.in); // Re-instantiate the input scanner object here

            // Admin implementation of updating a course
            System.out.print("\033[H\033[2J");
            System.out.println("===== UPDATE COURSE =====\n");

            System.out.print("Enter course name : ");
            String name = input.nextLine();

            System.out.println("Enter course id : ");
            String id = input.nextLine();

            List<Course> allCourses = Course.getAllCourses();

            for (Course course : allCourses) {
                if (course.getCourseName().equalsIgnoreCase(name) && course.getCourseId().equalsIgnoreCase(id)) {
                    System.out.print("Enter new course name : ");
                    course.setCourseName(input.nextLine());

                    System.out.print("Enter new course id : ");
                    course.setCourseId(input.nextLine());

                    System.out.print("Enter new subjects taught (separated by commas) : ");
                    course.setSubjectTaught(input.nextLine().split(","));

                    System.out.print("Enter new course duration : ");
                    course.setCourseDuration(input.nextInt());
                    input.nextLine(); // consume the remaining newline character

                    System.out.print("Enter new employment opportunities (separated by commas) : ");
                    course.setEmploymentOpportunities(input.nextLine().split(","));

                    System.out.print("Enter new scope for further studies (separated by commas) : ");
                    course.setScopeForFutherStudies(input.nextLine().split(","));

                    System.out.print("Does the course offer scholarship facilities? (true/false) ");
                    course.setScholarshipFacilities(input.nextBoolean());

                    System.out.print("Enter new fee structure : ");
                    course.setFeeStructure(input.nextInt());

                    System.out.print("Enter new maximum number of students : ");
                    course.setMaximumStudent(input.nextInt());

                    System.out.print(
                            "Enter new medium of study (FOUNDATION, DIPLOMA, UNDERGRADUATE, POSTGRADUATE, PHD) : ");
                    course.setMediumStudy(MediumOfStudy.valueOf(input.next().toUpperCase()));

                    System.out.print("\nCourse " + course.getCourseName() + " has been updated successfully.");

                    System.out.print("\nPress 0 to return : ");

                    int selection = input.nextInt();
                    if (selection == 0)
                        adminStrategy.manageCourse(user);
                    return;
                }
            }
            System.out.println("Course not found.");
        }

    }

    public void handleRemoveCourse(User loggedInUser) {
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
        if (loggedInUser instanceof Admin) {
            // Admin implementation of deleting a course
            Scanner usInput = new Scanner(System.in);
            List<Course> courses = Course.getAllCourses();
            List<Course> coursesToRemove = new ArrayList<>();

            System.out.print("\033[H\033[2J");
            System.out.println("===== DELETE THE PROGRAMMES =====\n");

            int i = 1;
            for (Course course : courses) {
                System.out.println("(" + i + ") " + course.getCourseName());
                i++;
            }

            System.out.print("Enter the name of the course to remove : ");
            String courseName = usInput.nextLine();

            for (Course course : courses) {
                if (course.getCourseName().equalsIgnoreCase(courseName)) {
                    coursesToRemove.add(course);
                }
            }

            for (Course course : coursesToRemove) {
                courses.remove(course);
            }

            if (coursesToRemove.isEmpty()) {
                System.out.println("Course not found");
            } else {
                System.out.println("Course removed successfully");
            }

            System.out.print("\nPress 0 to return : ");
            int selection = input.nextInt();

            if (selection == 0)
                adminStrategy.manageCourse(loggedInUser);
        } else if (loggedInUser instanceof Student) {
            // Student implementation of deleting a course
            System.out.print("\033[H\033[2J");
            List<Course> registeredCourses = ((Student) loggedInUser).getCourses();

            System.out.println("===== UNREGISTERED COURSES =====");

            if (registeredCourses.isEmpty()) {
                System.out.println("You haven't registered for any courses yet.");
                return;
            }

            for (int i = 0; i < registeredCourses.size(); i++) {
                System.out.println("(" + (i + 1) + ") " +
                        registeredCourses.get(i).getCourseName());
            }
            int choice = 0;
            System.out.print("\nSelect a course to unregister from : ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Invalid input, please enter a number.");
                return;
            }

            if (choice > 0 && choice <= registeredCourses.size()) {
                Course courseToUnregister = registeredCourses.get(choice - 1);
                ((Student) loggedInUser).removeCourse(courseToUnregister);
                System.out.println("You have been unregistered from "
                        + courseToUnregister.getCourseName());
                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    studStrategy.manageCourse(loggedInUser);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

}
