package com.darian.design;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runnable 接口、Callable 接口
        // Runnable 线程异常的时候就会挂掉，连线程就没了
        // Callable 会 Throws Exception，正常有返回值，异常有异常

        // 假设 Runnable 在 JDK 1.1 提供 throws Exception
        // 程序在  1.0 运行，时是不兼容的
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("hello, world"));
        executorService.execute(() -> {
            throw new RuntimeException("Hello, world");
        });

        // Throwable: Exception \ Error 父类
        Future<String> future = executorService.submit(() -> "hello, world");
        // 取消，阻塞，叫做检查时异常
        // checked 异常，需要明确在方法签名
        // unChecked 异常：不强制在方法签名出现，建议还是出现，NullPointerException
        future.get();
        future.cancel(true);
        // 运行前，运行时，计算返回
        executorService.shutdown();

        System.out.println("Complete......");
    }
}
