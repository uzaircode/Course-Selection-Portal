// implement Interface Segregation Principle (ISP) as both Student and Admin class use all methods.
public interface ICourseOperation {
    void manageCourse(Course selectedCourse, User loggedInUser);

    void addOfferedCourse(Course selectedCourse, User loggedInUser);

    void removeOfferedCourse(Course course, User loggedInUser);
}
