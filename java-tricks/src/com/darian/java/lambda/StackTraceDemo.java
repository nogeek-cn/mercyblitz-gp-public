package com.darian.java.lambda;

import java.util.stream.Stream;

public class StackTraceDemo {
    public static void main(String[] args) {
//        Stream.of(Thread.currentThread().getStackTrace())
//                .forEach(System.out::println);

        long start = System.currentTimeMillis();

        int times = 10 * 10000;
        for (int i = 0; i < times; i++) {
            Thread.currentThread().getStackTrace();
        }
        long costTime = System.currentTimeMillis() - start;

        System.out.println(times + " 次调用一共耗时： " + costTime);
    }
}
