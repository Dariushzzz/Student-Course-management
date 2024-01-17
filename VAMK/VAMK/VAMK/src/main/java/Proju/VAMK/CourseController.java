package Proju.VAMK;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseRepository repository;

    // Constructor for CourseController that takes a CourseRepository as a parameter
    public CourseController(CourseRepository cr) {
        this.repository = cr;
    }

    // GET mapping for retrieving all courses
    @GetMapping("/courses")
    List<Courses> getAllCourses() {
        return (List<Courses>) repository.findAll();
    }

    // POST mapping for adding a new course
    @PostMapping("/courses")
    Courses addNewCourse(@RequestBody Courses courses) {
        return repository.save(courses);
    }

    // GET mapping for retrieving a specific course by ID
    @GetMapping("/courses/{courseID}")
    Courses getOneCourse(@PathVariable String courseID) {
        return repository.findById(courseID).orElseThrow(
                () -> new CoursesNotFoundException(courseID)
        );
    }

    // PUT mapping for updating a specific course by ID
    @PutMapping("/courses/{courseID}")
    Courses updateOneCourse(@RequestBody Courses newCourse, @PathVariable String courseID) {
        return repository.findById(courseID)
                .map(existingCourse -> {
                    existingCourse.setName(newCourse.getName());
                    existingCourse.setTeacher(newCourse.getTeacher());

                    return repository.save(existingCourse);
                })
                .orElseGet(() -> {
                    newCourse.setCourseID(courseID);
                    return repository.save(newCourse);
                });
    }
}
