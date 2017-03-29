package hello;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/create")
    public String createUserForm(Person person) {
        return "form";
    }

    @PostMapping("create")
    public String createEntry(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        User user = userRepository.findOne(1L);
        person.setUser(user);
        personRepository.save(person);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupForm(User user) {
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userRepository.save(user);
        return "redirect:/";

    }

    @GetMapping("/user/{id}")
    public String readUser(@PathVariable Long id, Person person, Model model) {
        Person user = personRepository.findOne(id);
        model.addAttribute(user);
        return "user";
    }

    @GetMapping("/user/edit/{id}")
    public String editPage(@PathVariable Long id, Person person, Model model) {
        Person user = personRepository.findOne(id);
        model.addAttribute(user);
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
        return "redirect:/";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        personRepository.delete(id);
        return "redirect:/";
    }
}