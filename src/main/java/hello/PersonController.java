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

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

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

    @GetMapping("/user/edit/{id}")
    public String viewUpdateForm(Person person) {
        return "update-form";
    }

    @PostMapping("/user/edit/{id}")
    public String updateUser(@PathVariable Long id, @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-form";
        }
        Person up = personRepository.findOne(id);
        up.setFirstName(person.getFirstName());
        up.setLastName(person.getLastName());
        up.setAge(person.getAge());
        up.setEmail(person.getEmail());

        personRepository.save(up);
        return "redirect:/all";
    }



    @GetMapping("/all")
    public @ResponseBody Iterable<Person> getAllPersons() {
       return personRepository.findAll();
    }
}