abstract class CourseOperation {
    // template method
    public void execute(Course selectedCourse, User loggedInUser) {
        addCourse(selectedCourse, loggedInUser);
    }

    // abstract methods
    public abstract void addCourse(Course selectedCourse, User loggedInUser);
}