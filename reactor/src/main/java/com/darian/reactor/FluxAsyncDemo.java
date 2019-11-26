package com.darian.reactor;

import com.darian.utils.PrintUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/***
 * {@link Flux} 异步操作
 */
public class FluxAsyncDemo {
    public static void main(String[] args) throws InterruptedException {
        // 当前线程
        Flux.range(0,10)
                .publishOn(Schedulers.immediate())
                .subscribe(PrintUtils::printlnFormart);

        // 单线程异步执行
        Flux.range(0,10)
                .publishOn(Schedulers.single())
                .subscribe(PrintUtils::printlnFormart);


        // 弹性线程池异步执行
        Flux.range(0,10)
                .publishOn(Schedulers.elastic())
                .subscribe(PrintUtils::printlnFormart);

        // 并行线程池执行
        Flux.range(0, 10)
                .publishOn(Schedulers.parallel())
                .subscribe(PrintUtils::printlnFormart);

        // 强制让主线程执行完毕，强制父线程执行完毕，那么子线程也必须执行完成
        Thread.currentThread().join();
    }
}
