package com.darian.springbootconfigurations.controller;

import com.darian.springbootconfigurations.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final Person person;

    @GetMapping("person")
    public Person person(){
        return person;
    }
}
