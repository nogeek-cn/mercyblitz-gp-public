package com.darian.java8concurrency.Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 2. 异步执行，阻塞操作
         **/
        CompletableFuture asyncCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("hello, world"));
        // 仍然是阻塞操作
        asyncCompletableFuture.get();
        System.out.println("Starting......");
    }
}
