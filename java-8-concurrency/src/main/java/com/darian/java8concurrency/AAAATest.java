package com.darian.java8concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

public class AAAATest {

    public static void main(String[] args) {
        Perple perple = new Perple("1");
        Person person = new Person();
        BeanUtils.copyProperties(perple,person);
        System.out.println(person);

    }

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    static class Perple {
        private String id;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Person {
        private String id;
    }
}
