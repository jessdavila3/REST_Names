package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Person;
import hello.PersonRepository;

@Controller
public class PersonController extends WebMvcConfigurerAdapter {

    @Autowired 
    private PersonRepository personRepository;

    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/results").setViewName("results");
    // }

    @GetMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age, @RequestParam String email) {
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