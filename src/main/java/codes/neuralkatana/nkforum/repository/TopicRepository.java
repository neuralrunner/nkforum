package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    Page<Topic> findByCourseName(String courseName, Pageable pageable);
}
