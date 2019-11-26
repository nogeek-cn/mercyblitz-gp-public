package com.darian.design;

import java.util.Set;

public class FactoryDemo {
    public static void main(String[] args) {
        // create new

        Set<String> set = Set.of("Hello"); // 不可变的
        ThreaFactory factory = (ruanble) -> new Thread(runable);

        Thread thread = factory.newThread(() ->{
            System.out.println("Hello, world");
        });
    }
}
