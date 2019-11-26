package com.darian;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LambdaReduce {

    public static void main(String[] args) {
        Person person1 = new Person(1, "11");
        Person person2 = new Person(null, "darian");
        Person person3 = new Person(null, "dddd");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        List<Person> personNotNullList = personList.stream()
                .filter(person -> person.getId() != null)
                .collect(toList());


        personList.removeAll(personNotNullList);

        System.out.println(personNotNullList);
        System.out.println(personList);
    }

    @Data
    @AllArgsConstructor
    public static class Person {
        private Integer id;
        private String name;
    }
}
