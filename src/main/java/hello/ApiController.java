package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jesse on 3/20/2017.
 */
@Controller
public class ApiController {

    @Autowired
    private PersonRepository personRepository;

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
}
