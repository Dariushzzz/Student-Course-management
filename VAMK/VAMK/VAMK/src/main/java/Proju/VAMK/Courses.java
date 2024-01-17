package Proju.VAMK;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity

@Table
public class Courses {

    // Default constructor required by JPA
    public Courses() {

    }


    @Id
    @Column(name = "courseID")
    private String courseID;


    @Column(name = "name")
    private String name;


    @Column(name = "teacher")
    private String teacher;

    // Constructor for creating a Courses object with courseID, name, and teacher
    public Courses(String courseID, String name, String teacher) {
        this.courseID = courseID;
        this.name = name;
        this.teacher = teacher;
    }

    // Getters and setters
    public String getCourseID() {
        return courseID;
    }


    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getTeacher() {
        return teacher;
    }


    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // ToString method for creating a string representation of the Courses object
    public String toString() {
        return "Courses{courseID=" + this.courseID + ", name='" + this.name + "', teacherName='" + this.teacher + "'}";
    }
}
