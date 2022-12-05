public class Professor extends User {
    private int professorId;
    private String faculty;

    public Professor(String username, String password, String emailAddress, int phoneNumber, int professorId,
            String faculty) {
        super(username, password, emailAddress, phoneNumber);
        this.professorId = professorId;
        this.faculty = faculty;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
