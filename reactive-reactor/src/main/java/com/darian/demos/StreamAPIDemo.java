package com.darian.demos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIDemo {
    public static void main(String[] args) {
        // Stream => 1,2,3,4,5
        // Stream 管道
        //  Stream 运算模式
        // 穿行
        Stream.of(1, 2, 3, 4, 5, 6).forEach(System.out::print);
        System.out.println("\n========================");
        // 并行
        Stream.of(1, 2, 3, 4, 5, 6).parallel().forEach(System.out::print);
        // 并行加顺序
        System.out.println("\n===================");
        Stream.of(1, 2, 3, 4, 5, 6).parallel().forEachOrdered(System.out::print);


    }
}