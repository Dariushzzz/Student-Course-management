package Proju.VAMK;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
class VamkApplicationTests {
@Autowired
StudentRepository repository;


	@Test
	void contextLoads() {
	}

	@Test
	void CreateStudent()
	{
		Students s = new Students("666", "Lalli", "Lactosis", "Lalli@edu.joku.fi");
		repository.save(s);

	}



   @Autowired
   CourseRepository CourseRepo;
   @Test
   void CreateCourses()
   {
	   Courses c = new Courses("124", "Matikka", "Jamochello");
	   CourseRepo.save(c);
   }


   @Autowired

   StudentRepository studentRepository;
   @Test
	void UpdateStudents()
   {
	   Students s = studentRepository.findById("666").get();
	   s.setFirstname("Loka");
	   studentRepository.save(s);
   }


   @Autowired
   CourseRepository courseRepository;
   @Test
   void UpdateCourses()
   {
	 Courses c = courseRepository.findById("124").get();
	 c.setTeacher("Lassiiiii");
	 courseRepository.save(c);
   }

   @Autowired
   AdminRepository AdminRepo;
   @Test

	void AdminTest()
   {
	   Admin A = new Admin("Admin", "pass");
	   AdminRepo.save(A);
   }




   @Test
	void readStudents()
   {
	   Students s = studentRepository.findById("50").get();
		assertThat(s).isNotNull();
		assertThat(s.getFirstname()).isEqualTo("Hermanni");
   }



   @Test
	void readCourses()
   {
	   Courses c = courseRepository.findById("124").get();
	   assertThat(c).isNotNull();
	   assertThat(c.getName()).isEqualTo("Matikka");
   }


   @Test
	void DeleteStudent()
   {
	   Students s = studentRepository.findById("666").get();
	   studentRepository.delete(s);
   }


}


