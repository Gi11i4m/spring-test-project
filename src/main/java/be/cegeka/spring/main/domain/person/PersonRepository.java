package be.cegeka.spring.main.domain.person;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Person> findByName(String name) {
        return em.createQuery("from Person p where p.name = :name", Person.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Person> getPersons() {
        return em.createQuery("from Person", Person.class)
                .getResultList();
    }
}
