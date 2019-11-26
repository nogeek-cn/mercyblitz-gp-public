package com.darian.springbootjmx.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person")
    public Person person(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {
        Person person = new Person();
        if (person != null) {
            person.setName(name);
        }
        if (description != null) {
            person.setDiscription(description);
        }

        return person;
    }
}
