package com.darian.asyncweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.darian.asyncweb.servlet")
public class AsyncWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncWebApplication.class, args);
	}
}

