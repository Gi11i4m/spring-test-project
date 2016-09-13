package be.cegeka.spring.main.domain.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void createPerson() throws Exception {
        personService.createPerson("Jef");

        Person jef = new Person("Jef");
        verify(personRepository).save(refEq(jef));
    }

}