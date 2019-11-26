package com.darian.springbootjmx.spring;


import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;


@Component
@ManagedResource
public class Person {
    private String name;
    private String discription;

    @ManagedAttribute(defaultValue = "darian will go",
            description = "这是一个名称字段！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}