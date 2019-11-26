package com.darian.java8concurrency.Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 真正的异步
         **/
        // 非 lambda 写法
        CompletableFuture asyncCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello.World";
            }
        });

        // lambda 写法
        CompletableFuture<String> asynoCompletableFuture = CompletableFuture.supplyAsync(() -> {
            // 获取数据操作，假设来自于数据库
            return String.format("[Thread: %s ]hello。。。。\n",
                    Thread.currentThread().getName());
        });

        String value = asynoCompletableFuture.get();
        System.out.println("value = " + value);
        System.out.println(String.format("[Thread: %s ]starting。。。。\n",
                Thread.currentThread().getName()));
    }
}
