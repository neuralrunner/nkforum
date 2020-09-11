package codes.neuralkatana.nkforum.repository;

import codes.neuralkatana.nkforum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
