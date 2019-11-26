package com.darian.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallBackDemo {
    public static void main(String[] args) {
        CallbackExecutor executor = new CallbackExecutor();
        // 执行回调
        executor.executor(() -> System.out.println("hello, world"));
        executor.executor(() -> System.out.println("ABC"));
        executor.run();

    }

    public static interface Callback {
        void callback();
    }

    public static class CallbackExecutor {
        private Queue<Callback> callbackQueue = new LinkedList<>();

        public void executor(Callback callback) {
            callbackQueue.add(callback);
        }

        public void run() {
            callbackQueue.forEach(callback -> callback.callback());
        }
    }

    public static void ddd() {
        // CallBack 接口不是程序显示的执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("Hello, world"));
        System.out.println("ABC");
        executorService.shutdown();
    }
}
