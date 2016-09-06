package be.cegeka.spring.main.domain.person;

import be.cegeka.spring.main.SpringRootConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
@Transactional
@Rollback(false)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @Test
    public void save_createsId() {
        person = new Person("Jef");

        personRepository.save(person);

        assertThat(person.getId()).isNotNull();
    }

    @Test
    public void findByName() {
        Person jef = personRepository.save(new Person("Jef"));

        assertThat(personRepository.findByName("Jef")).isEqualTo(jef);
    }
}
