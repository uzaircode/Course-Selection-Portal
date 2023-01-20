interface ICourseOperation {

    void manageCourse(Course selectedCourse, User loggedInUser);

    // void addCourse(Course selectedCourse, User loggedInUser);

    void unregisteredFromCourse(Course course, User loggedInUser);
}
