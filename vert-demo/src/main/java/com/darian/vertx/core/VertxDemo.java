package com.darian.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class VertxDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        demoVerticle(vertx);
        vertx.close();

    }

    private static void demoVerticle(Vertx vertx) {
        vertx.deployVerticle(new AbstractVerticle() {

            @Override
            public void start(Future<Void> startFuture) throws Exception {
                System.out.println("start。。。");
                startFuture.complete();
            }

            @Override
            public void stop() throws Exception {
                System.out.println("stop。。。。");
            }
        });
    }

    private static void demoStPeriodic(Vertx vertx) {
        // 实现定时器
        vertx.setPeriodic(500, System.out::println);
        vertx.setPeriodic(500, System.out::println);
        vertx.setPeriodic(500, System.out::println);

        // 底层就是类似的实现方式：
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(() -> System.out.println("Hello, world"),
                1000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }
}
