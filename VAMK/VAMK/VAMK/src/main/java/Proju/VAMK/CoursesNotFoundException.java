package Proju.VAMK;


public class CoursesNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CoursesNotFoundException(String courseID) {
        super("Course not found " + courseID);
    }
}