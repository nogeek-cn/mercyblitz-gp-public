package com.darian.java8concurrency.before5;

import java.sql.SQLException;

/**
 * <br>
 * <br>Darian
 **/
public class ThreadMain {
    public static void main(String[] args) {
        // 子线程
        Thread thread = new Thread(new Runnable() {
            /****
             * synchronized 关键字是一种编程语言修饰符号
             */
            @Override
            public synchronized   void run() {
                System.out.printf("[Thread: %s ]hello\n", Thread.currentThread().getName());
            }
        }, "sub");

        thread.start();

        System.out.printf("[Thread: %s ]start......\n", Thread.currentThread().getName());
    }
}
