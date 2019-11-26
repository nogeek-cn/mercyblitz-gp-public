package com.darian.jspinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.darian.jsp.in.spring.web.controller")
public class JspInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspInSpringBootApplication.class, args);
    }
}
