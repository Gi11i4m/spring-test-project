package be.cegeka.spring.main.domain.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person.getName());
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getPersons(@RequestParam(value = "name",required = false) String name) {
        return personService.getPersons(name);
    }
}
