package be.cegeka.spring.main;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getTitle(String name) {
        return "Hello " + name;
    }
}
