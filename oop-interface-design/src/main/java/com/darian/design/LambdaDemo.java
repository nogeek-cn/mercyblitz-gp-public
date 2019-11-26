package com.darian.design;

import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {
        echo(() -> "hello, world");
    }

    public static void echo(Supplier<?> valuable){
        System.out.println(valuable.get());
    }

    @FunctionalInterface
    public static interface Valuable<V> {
        V get();
    }
}
