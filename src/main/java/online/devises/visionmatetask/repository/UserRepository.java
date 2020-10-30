package online.devises.visionmatetask.repository;

import online.devises.visionmatetask.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
