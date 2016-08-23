package be.cegeka.spring.main.domain.person;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public Person save(Person person) {
        em.persist(person);
        return person;
    }

    public void delete(Person person) {
        em.remove(person);
    }
}
