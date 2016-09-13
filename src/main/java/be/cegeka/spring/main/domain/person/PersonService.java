package be.cegeka.spring.main.domain.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(String personName) {
        return personRepository.save(new Person(personName));
    }

    public List<Person> getPersons(String name) {
        if (name == null) {
            return personRepository.getPersons();
        }
        return personRepository.findByName(name);
    }
}
