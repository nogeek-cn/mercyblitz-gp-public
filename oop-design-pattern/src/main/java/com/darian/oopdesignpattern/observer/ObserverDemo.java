package com.darian.oopdesignpattern.observer;

import java.util.Observable;

/***
 * 观察者模式 Demo
 * Observable 是一个维护有序的 Observer 集合 ， Subject、Publisher
 * Observer = consumer = Subscriber
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // JDk 存在观察者模式的实现。
        MyObservable observable = new MyObservable();

        observable.addObserver((o, arg) -> {
            System.out.println("观察者 1：邮件订阅：" + arg);
        });
        observable.addObserver((o, arg) -> {
            System.out.println("观察者 2：邮件订阅：" + arg);
        });
        observable.addObserver((o, arg) -> {
            System.out.println("观察者 3：邮件订阅：" + arg);
        });

        // 调整变化
        observable.setChanged();

        // 通知变化到所有观察者
        observable.notifyObservers("邮件通知：Hello, World");
    }

    private static class MyObservable extends Observable{
        // 子类提升方法从 protected 到 public
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
