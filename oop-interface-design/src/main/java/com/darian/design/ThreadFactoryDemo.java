package com.darian.design;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/***
 * 抽象工厂
 */
public class ThreadFactoryDemo {

    // 1.  接口或者抽象类
    // 2.  创建实例
    // 3.  抽象方法

    // ThreadFactory
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };

        Thread thread = factory.newThread(() -> {
            System.out.println("hello, world");
        });
        thread.start();
        // 抽象工厂是抽象的方法

        // 静态工厂
        ExecutorService executorService = Executors.newSingleThreadExecutor(factory);
        executorService.execute(() -> System.out.println("hello, world"));
        executorService.shutdown();
    }
}