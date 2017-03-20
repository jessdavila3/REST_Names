package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import hello.Person;
import hello.PersonRepository;

@Controller
public class PersonController extends WebMvcConfigurerAdapter {

    @Autowired 
    private PersonRepository personRepository;

    @GetMapping("/create")
    public String createUserForm(Person person) {
        return "form";
    }

    @PostMapping("create")
    public String createUser(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        personRepository.save(person);
        return "redirect:/all";
    }

    @GetMapping("/user/{id}")
    public @ResponseBody Person readUser(@PathVariable Long id) {
        return personRepository.findOne(id);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Long id) {
        return null; // how can we update a created user?
    }

    @PostMapping("/api/users")
    public String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String email) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        p.setEmail(email);
        personRepository.save(p);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
       // returns json or xml with all persons
       return personRepository.findAll();
    }
}