package hello;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jesse on 3/29/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
