package com.darian.reactivewebdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.darian.reactivewebdemo")
public class ReactiveWebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebDemoApplication.class, args);
	}

}

