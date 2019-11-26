package com.darian.oopdesignpattern.flyweight;

public class StringInterningDemo {
    public static void main(String[] args) {
        String value = new String("Hello"); // "Hello"
        String newValue = value.intern(); // 放到常量池里边
    }
}
