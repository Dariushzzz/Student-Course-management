package Proju.VAMK;


public class StudentsNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public StudentsNotFoundException(String studentID) {
        super("Student not found " + studentID);
    }
}
