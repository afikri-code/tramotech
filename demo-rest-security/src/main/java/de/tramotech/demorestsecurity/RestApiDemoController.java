package de.tramotech.demorestsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiDemoController {
    List<Person> persons = new ArrayList<>();
    public RestApiDemoController() {
        persons.addAll(List.of(new Person(1,"Max"), new Person(2,"Leila")));
    }
    @GetMapping("/persons")
    Iterable<Person> getPersons() {
        return this.persons;
    }

    @PostMapping("/persons")
    Person addPerson(@RequestBody Person person) {
        persons.add(person);
        return person;
    }
}
