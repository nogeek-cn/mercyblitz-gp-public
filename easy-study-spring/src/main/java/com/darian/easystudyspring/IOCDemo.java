package com.darian.easystudyspring;

import org.springframework.beans.factory.annotation.Autowired;

public class IOCDemo {

    @Autowired
    private String name;

    @Autowired
    public IOCDemo(Integer age) {
        this.age = age;
    }

    @Autowired
    public void setName(String name) {

    }

    private Integer age;

    public static void main(String[] args) {

    }
}
