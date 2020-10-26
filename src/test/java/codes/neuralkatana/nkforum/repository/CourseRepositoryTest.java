package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
//Not change the Database configuration for test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest {
    //H2 is been used here, but if there was another database being used for test
    //Spring would load that here. Since it's being used two distinct application.properties
    //It's not a bad practice, as long as there is an amount of data loaded to provide the tests
    //Or Mockups are made

    @Autowired
    private CourseRepository repository;

    private Course course;

    @Test
    void shouldLoadACourseByName(){
        Course c3 = new Course();
        c3.setName("Spring MVC");
        c3.setCategory("Programming");
        repository.save(c3);

        String courseName = "Spring MVC";
        course = repository.findByName(courseName);
        assertNotNull(course);
        assertEquals(courseName,course.getName());
    }

    @Test
    void shouldNotLoadACourseWithUnregisteredName(){
        String courseName = "Quantum Physics";
        course = repository.findByName(courseName);
        assertNull(course);
    }

}