package com.darian.utils;

public class PrintUtils {
    public static void printlnFormart(Object message) {
        System.out.println("[Thread:" +
                Thread.currentThread().getName() + "] : "
                + String.valueOf(message));
    }
}
