package com.darian.spring5webFluxdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;

    @Override
    public String toString() {
        String message = "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
        println(message);
        return message;
    }

    public static void println(Object message) {
        System.out.println(Thread.currentThread().getName() + message);
    }
}
