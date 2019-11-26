package com.darian.demos;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.util.concurrent.*;

public class BlockingQueryDB {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueryDB blockingQueryDB = new BlockingQueryDB();
//        blockingMode(blockingQueryDB);
//        cocurrentMode(blockingQueryDB);
//        reactiveModeMistake(blockingQueryDB);
//        reactiveMode(blockingQueryDB);
//        reactiveModeSubscribe(blockingQueryDB);
//        reactiveModeSubscribeAsync(blockingQueryDB);
        cocurrentMode100(blockingQueryDB);
        Thread.currentThread().join();
    }


    /***
     * 并发模式
     */
    public static void cocurrentMode100(BlockingQueryDB blockingQueryDB) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int sunCount = 200000;
        ExecutorService executorService = Executors.newFixedThreadPool(sunCount/2);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        // futureA 保存 queryA 的结果
        for (int i = 0; i < sunCount; i++) {
            completionService.submit(blockingQueryDB::queryA);
        }
        int count = 0;
        while (count < sunCount) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
        // 还有优化的写法，没必要阻塞，再阻塞。
        executorService.shutdown();
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【cocurrentMode】 queryA [ 100 ms ]  " + sunCount + "次，时间：" + costTime + " ms");
    }


    /***
     * 响应模式 （生产数据在不同的线程里边）
     * 真正的异步非阻塞式的编程
     */
    public static void reactiveModeSubscribeAsync(BlockingQueryDB blockingQueryDB) {
        long start = System.currentTimeMillis();
        Observable<Integer[]> observableA = Observable.fromCallable(blockingQueryDB::queryA);
        Observable<Integer[]> observableB = Observable.fromCallable(blockingQueryDB::queryB);


        observableA.subscribeOn(Schedulers.newThread())
                .subscribe(); // 没有订阅就没有执行
        observableB.subscribeOn(Schedulers.newThread()).subscribe();

        long costTime = System.currentTimeMillis() - start;
        System.out.println("【reactiveModeSubscribeAsync】 queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");

    }

    /***
     * 响应模式 （生产数据在同一个线程里边）
     */
    public static void reactiveModeSubscribe(BlockingQueryDB blockingQueryDB) {
        long start = System.currentTimeMillis();
        Observable<Integer[]> observableA = Observable.fromCallable(blockingQueryDB::queryA);
        Observable<Integer[]> observableB = Observable.fromCallable(blockingQueryDB::queryB);
        observableA.subscribe();
        observableB.subscribe();
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【reactiveModeSubscribe】 queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");
    }

    /***
     * 响应模式（没有消费）
     */
    public static void reactiveMode(BlockingQueryDB blockingQueryDB) {
        long start = System.currentTimeMillis();

        // Publisher
        // 发布 query A 操作
        Flowable<Integer[]> flowableA = Flowable.fromCallable(blockingQueryDB::queryA);
        // 发布 query B 数据操作
        Observable<Integer[]> observableb = Observable.fromCallable(blockingQueryDB::queryB);
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【reactiveMode】 queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");
    }

    /***
     * 响应模式 （写法错误, 仍然是迭代器模式）
     */
    public static void reactiveModeMistake(BlockingQueryDB blockingQueryDB) {
        long start = System.currentTimeMillis();

        Integer[] a = blockingQueryDB.queryA();
        Integer[] b = blockingQueryDB.queryB();
        // Publisher
        // 发布 query A 操作
        Flowable<Integer[]> flowableA = Flowable.just(a);
        // 发布 query B 数据操作
        Observable<Integer[]> observableb = Observable.just(b);
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【reactiveModeMistake】 queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");
        // just 是完全调用 queryA() + queryB() >= 阻塞模式
    }

    /***
     * 并发模式
     */
    public static void cocurrentMode(BlockingQueryDB blockingQueryDB) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        // futureA 保存 queryA 的结果
        Future<Integer[]> futureA = completionService.submit(blockingQueryDB::queryA);
        // futureB 保存 queryB 的结果
        Future<Integer[]> futureB = completionService.submit(blockingQueryDB::queryB);
        // 阻塞

        int count = 0;
        while (count < 2) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
//        futureA.get();
//        futureB.get();
        // 还有优化的写法，没必要阻塞，再阻塞。
        executorService.shutdown();
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【cocurrentMode】 queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");
    }

    /***
     * 阻塞模式
     */
    public static void blockingMode(BlockingQueryDB blockingQueryDB) {
        long start = System.currentTimeMillis();
        blockingQueryDB.queryA();
        blockingQueryDB.queryB();
        long costTime = System.currentTimeMillis() - start;
        System.out.println("【blockingMode】queryA [ 100 ms ] + queryB [ 150 ms ] 时间：" + costTime + " ms");
    }

    public Integer[] queryA() {
        sleep(100);
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: queryA() .....");
        return of(1, 2, 3, 4, 5);
    }

    public Integer[] queryB() {
        sleep(150);
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: queryB() .....");
        return of(6, 7, 8, 9, 10);
    }

    public static void sleep(long times) {
        try {
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> T[] of(T... values) {
        return values;
    }

    public static void reactivefromObservable(Observable<BlockingQueryDB> blockingQueryDBObservable) {
        blockingQueryDBObservable.subscribeOn(Schedulers.newThread())
                .subscribe();
    }

    public static void reactiveFluent(BlockingQueryDB blockingQueryDB) {
        // 流式处理
        // 开发人员无需关注并发或者线程池
        Observable.fromCallable(blockingQueryDB::queryA)
                .subscribeOn(Schedulers.newThread()) // 决定同步/异步
                .doOnNext(integers -> {
                    // 数据消费正常逻辑
                })
                .doOnError(throwable -> {
                    // 数据消费异常逻辑
                })
                .doOnComplete(() -> {
                    // 执行结束逻辑
                })
                .doFinally(() -> {
                    // 最终执行......
                });
    }

    public static void executorService(BlockingQueryDB blockingQueryDB) {
        Future<Integer[]> futureA = Executors.newFixedThreadPool(2)
                .submit(blockingQueryDB::queryA);
        try {
            // 阻塞
            futureA.get();
            // 正常的逻辑
        } catch (Exception e) {
            // 异常的逻辑
        }
        // 结束后的逻辑
    }
}