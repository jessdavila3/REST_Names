package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.tomcat.util.net.SocketBufferHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        repository.save(new Person("Jesse", "Davila", 24));
        repository.save(new Person("Ian", "Anderson", 25));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Person person: repository.findAll()) {
            System.out.println(person);
        }
        System.out.println();
    }

}