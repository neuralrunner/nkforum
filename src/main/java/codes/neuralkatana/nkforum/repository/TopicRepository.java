package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {

}
