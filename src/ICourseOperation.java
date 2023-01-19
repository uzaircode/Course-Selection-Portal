interface ICourseOperation {
    void addCourse(Course selectedCourse, User loggedInUser);

    void unregisteredFromCourse(Course course, User loggedInUser);
}
