package be.cegeka.spring.main.domain.person;

import be.cegeka.spring.main.SpringRootConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class})
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @Test
    public void saveLoadTest() {
        person = new Person("Jef");

        assertThat(personRepository.save(person).getId()).isNotNull();
    }

}
