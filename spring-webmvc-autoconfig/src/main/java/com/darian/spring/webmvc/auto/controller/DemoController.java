package com.darian.spring.webmvc.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired(required = false)
    @Qualifier("helloWorld")
    private String helloWorld;

    @GetMapping
    public String index() {
        return helloWorld;
    }
}
