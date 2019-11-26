package com.darian.java8concurrency.Java8;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo4 {
    public static void main(String[] args) throws IOException {
        /**
         * 合并操作
         **/
        // reactive -> flatMap 有点像
        CompletableFuture combinedCompletableFuture = CompletableFuture.supplyAsync(() -> {
            // 获取数据操作，假设来自于数据库
            return String.format("[Thread: %s ]hello。。。。\n",
                    Thread.currentThread().getName());
        }).thenApply(value -> {
            return value + "---来自于数据库" + "[" + Thread.currentThread().getName() + "]";
        }).thenApply(value -> {
//            int i = 1 / 0;
            return value + " at " + LocalDate.now();
        }).thenApply(value -> {
            System.out.println(value);
            return value;
        }).thenRun(() -> {
            System.out.println("操作结束");
        }).exceptionally(CompletableFutureDemo4::apply);

//        while (!asynoCompletableFuture.isDone()) {
//        }

        System.out.println("starting........");

        System.in.read();
    }

    private static Void apply(Throwable throwable) {
        System.out.println(throwable);
        return null;
    }
}
