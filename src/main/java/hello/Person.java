package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // tells Hibernate that this will be a table
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, max=20)
    public String firstName;

    @NotNull
    @Size(min=2, max=20)
    public String lastName;

    @NotNull
    @Min(16)
    public int age;

    private String email;

    public Person() {}

    public Person(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    public String toString() {
        return "Person(Name: " + this.firstName + " " + this.lastName + ", Age: " + this.age + ")";
    }
}


