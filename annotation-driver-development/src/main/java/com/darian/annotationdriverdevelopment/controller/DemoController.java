package com.darian.annotationdriverdevelopment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello, World";
    }


}