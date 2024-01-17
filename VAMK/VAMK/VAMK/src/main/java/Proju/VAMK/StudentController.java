package Proju.VAMK;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    // Constructor for StudentController that takes a StudentRepository as a parameter
    public StudentController(StudentRepository sr) {
        this.repository = sr;
    }

    // GET mapping for retrieving all students
    @GetMapping("/students")
    List<Students> getAllStudents() {
        return (List<Students>) repository.findAll();
    }

    // POST mapping for adding a new student to the database
    @PostMapping("/students")
    Students addNewStudent(@RequestBody Students students) {
        return repository.save(students);
    }

    // GET mapping for retrieving a specific student by ID
    @GetMapping("/students/{studentID}")
    Students getOneStudent(@PathVariable String studentID) {
        return repository.findById(studentID).orElseThrow(
                () -> new StudentsNotFoundException(studentID)
        );
    }

    // PUT mapping for updating a specific student by ID
    @PutMapping("/students/{studentID}")
    Students updateOneStudent(@RequestBody Students newStudent, @PathVariable String studentID) {
        return repository.findById(studentID)
                .map(existingStudent -> {
                    existingStudent.setFirstname(newStudent.getFirstname());
                    existingStudent.setLastname(newStudent.getLastname());
                    existingStudent.setEmail(newStudent.getEmail());
                    return repository.save(existingStudent);
                })
                .orElseGet(() -> {
                    newStudent.setStudentID(studentID);
                    return repository.save(newStudent);
                });
    }
}
