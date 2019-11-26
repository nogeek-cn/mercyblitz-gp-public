package com.darian.configuration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@TestPropertySource(properties = {"name = darian", "age=32"})
public class SpringPropertyTest {

    @Autowired
    private Environment environment;

    @Test
    public void test() {
        System.out.println("name:" + environment.getProperty("name"));
        System.out.println("age:" + environment.getProperty("age",Integer.class));
    }
}
