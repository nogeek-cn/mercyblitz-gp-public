package com.darian.java8concurrency.before5;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <br>
 * <br>Darian
 **/
public class ThreadMain测试多线程是否结束 {
    public static void main(String[] args) {

        final boolean finished = false;

//        AtomicBoolean 是Java 5

        // 子线程
        Thread thread = new Thread(() -> System.out.printf("[Thread: %s ]hello\n", Thread.currentThread().getName()), "sub");

        thread.start();

        System.out.printf("[Thread: %s ]start......\n", Thread.currentThread().getName());
    }
}
