package be.cegeka.spring.main;

import be.cegeka.spring.main.domain.person.Person;
import be.cegeka.spring.main.domain.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

	private final HelloWorldService helloWorldService;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return helloWorldService.getTitle("World!");
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Helloooo";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public String helloName(@PathVariable("name") String name) {
		return helloWorldService.getTitle(name);
	}
}