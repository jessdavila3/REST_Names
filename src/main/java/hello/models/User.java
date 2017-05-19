package hello.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by jesse on 3/28/2017.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    @Size(min=5, max = 25)
    private String email;

    @Column(nullable = false, unique = true)
    @Size(min = 4, max = 20)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Person> persons;

    public User() {

    }

    public User(User user) {
        id = user.id;
        email = user.email;
        password = user.password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
