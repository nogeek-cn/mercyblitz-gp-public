package com.darian.oopdesignpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
public class OopDesignPatternApplication extends WebMvcConfigurerAdapter {

	@GetMapping("")
	public String hello(){
		return "hello, world";
	}

	public static void main(String[] args) {
		SpringApplication.run(OopDesignPatternApplication.class, args);
	}
}
