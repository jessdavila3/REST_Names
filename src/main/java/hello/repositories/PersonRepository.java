package hello.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import hello.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    public Person findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);

}