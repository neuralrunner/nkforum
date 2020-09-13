package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByName(String name);
}
