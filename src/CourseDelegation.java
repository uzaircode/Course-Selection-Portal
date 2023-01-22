import java.util.List;
import java.util.Scanner;

public class CourseDelegation {
    Scanner input = new Scanner(System.in);

    public void addOfferedCourse(User loggedInUser, Course selectedCourse) {
        if (loggedInUser instanceof Admin) {
            // Admin implementation of adding a course
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

                Course newCourse = new Course(id, name, subjects, duration, employmentOpportunities,
                        scopeForFurtherStudies,
                        scholarshipFacilities, feeStructure, maxStudents, medium);
                Course.addCourse(newCourse);

                System.out.println("\nCourse " + newCourse.getCourseName() + " has been created successfully.");

                System.out.print("\nPress 0 to return : ");
                int selection = input.nextInt();
                if (selection == 0)
                    return;
            } catch (

            NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (loggedInUser instanceof Student) {
            // Student implementation of adding a course
            System.out.print("\033[H\033[2J");
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();

            try (Scanner input = new Scanner(System.in)) {
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
                    studStrategy.manageCourse();
            }
        }
    }

    public void updateOfferedCourse(User user) {
        if (user instanceof Admin) {
            // Admin implementation of updating a course
            System.out.print("\033[H\033[2J");
            try (Scanner input = new Scanner(System.in)) {
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
                            return;
                        return;
                    }
                }
                System.out.println("Course not found.");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeOfferedCourse(User loggedInUser) {
        if (loggedInUser instanceof Admin) {
            // Admin implementation of deleting a course
            List<Course> courses = Course.getAllCourses();

            System.out.print("\033[H\033[2J");
            System.out.println("Enter the name of the course to remove :");
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
                return;
        } else if (loggedInUser instanceof Student) {
            // Student implementation of deleting a course
            StudentDashboardDisplayStrategy studStrategy = new StudentDashboardDisplayStrategy();
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

            try (Scanner input = new Scanner(System.in)) {
                int choice = 0;
                System.out.print("\nSelect a course to unregister from : ");
                choice = input.nextInt();
                if (choice > 0 && choice <= registeredCourses.size()) {
                    Course courseToUnregister = registeredCourses.get(choice - 1);
                    ((Student) loggedInUser).removeCourse(courseToUnregister);
                    System.out.println("You have been unregistered from "
                            + courseToUnregister.getCourseName());
                    System.out.print("\nPress 0 to return : ");
                    int selection = input.nextInt();
                    if (selection == 0)
                        studStrategy.manageCourse();
                } else {
                    System.out.println("Invalid choice.");
                }
            }

        }
    }
}
