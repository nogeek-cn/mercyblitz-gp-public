package com.darian.vertx.core;

import io.vertx.core.Vertx;

/***
 * EventbusDemo
 */
public class VertxEventBusDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        demoEventBus(vertx);
        vertx.close();
    }

    /***
     * 演示 Event Bus Demo
     * @param vertx
     */
    private static void demoEventBus(Vertx vertx) {
        String address = "test-address";
        // 事件订阅者（消费事件）
        vertx.eventBus().consumer(address, message -> {
            // 处理消息（事件）
            Object payload = message.body();
            System.out.println("Address:" + address + " -> message: " + payload);
        }).completionHandler(voidAsyncResult -> {
            System.out.println("消息消费结束");
        });

        // 事件发布者（发布事件）
        vertx.eventBus().publish(address, "hello, world");
        vertx.eventBus().publish(address, 123);
    }
}