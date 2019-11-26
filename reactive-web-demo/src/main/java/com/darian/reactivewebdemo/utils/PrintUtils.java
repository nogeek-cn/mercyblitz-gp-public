package com.darian.reactivewebdemo.utils;

public class PrintUtils {
    public static void println(Object value) {
        System.out.println("Thread[" + Thread.currentThread().getName() +
                "] ： " + String.valueOf(value));
    }
}
