package hello;

import java.util.List;


public interface PersonRepository {

    public Person findByFirstName(String firstName);
    public List<Person> findByLastName(String lastName);

}