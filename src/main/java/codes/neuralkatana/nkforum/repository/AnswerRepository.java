package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
