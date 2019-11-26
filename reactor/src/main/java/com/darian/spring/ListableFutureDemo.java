package com.darian.spring;

import com.darian.utils.PrintUtils;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/***
 * {@link org.springframework.util.concurrent.ListenableFuture}
 */
public class ListableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncListenableTaskExecutor executor = new SimpleAsyncTaskExecutor();
        // ListenableFuture 实例
        ListenableFuture<Integer> future = executor.submitListenable(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 1;
            }
        });

        // 欠佳 callBack
        future.addCallback(new ListenableFutureCallback<>() {
            public void onFailure(Throwable throwable) {
                PrintUtils.printlnFormart(throwable);
            }

            public void onSuccess(Integer integer) {
                PrintUtils.printlnFormart(integer);
            }
        });

        // Future 直到计算结果（阻塞）
        future.get();

        future = executor.submitListenable(() -> 2);
        // callback 消费完了就没有了
        future.addCallback(new ListenableFutureCallback<>() {
            public void onFailure(Throwable throwable) {
                PrintUtils.printlnFormart(throwable);
            }

            public void onSuccess(Integer integer) {
                PrintUtils.printlnFormart(integer);
            }
        });
        future.get();
    }
}
