package com.darian.java8concurrency.Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 1. 完成操作（可以被其他线程去做）
         **/
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        completableFuture.complete("Hello, World");
        String value = completableFuture.get();
        System.out.println(value);
    }
}
