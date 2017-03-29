package hello;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // tells Hibernate that this will be a table
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, max=20)
    private String firstName;

    @NotNull
    @Size(min=2, max=20)
    private String lastName;

    @NotNull
    @Min(16)
    private int age;

    private int phone_Number;

    private String email;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Person() {}

    public Person(String firstName, String lastName, int age, int phone_Number, String email, Long user_Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone_Number = phone_Number;
        this.email = email;
    }

    public String toString() {
        return "Person(Name: " + this.firstName + " " + this.lastName + ", Age: " + this.age + ")";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


