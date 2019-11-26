package com.darian.springbootconfigurations;

import com.darian.springbootconfigurations.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Person.class)
public class SpringBootConfigurationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigurationsApplication.class, args);
    }

}
