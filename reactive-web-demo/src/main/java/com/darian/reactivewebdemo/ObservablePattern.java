package com.darian.reactivewebdemo;

import com.darian.reactivewebdemo.utils.PrintUtils;

import java.util.Observable;

import static com.darian.reactivewebdemo.utils.PrintUtils.*;

public class ObservablePattern {

    public static void main(String[] args) {
        MyObserverable myObserverable = new MyObserverable();

        // 当前的实现是 同步 + 非阻塞
        println("observalber 添加观察者！！");
        // 一个 Observable 对应 多个 Observer
        myObserverable.addObserver((o, arg) -> println("观察者【1】 收到数据更新："+arg));
        myObserverable.addObserver((o, arg) -> println("观察者【2】 收到数据更新："+arg));
        myObserverable.addObserver((o, arg) -> println("观察者【3】 收到数据更新："+arg));

        println("observable 通知所有观察者！");
        // 说明已经改变了
        myObserverable.setChanged();
        myObserverable.notifyObservers("Hello, world");// 发布数据 -》 Push Data

        println("通知结束");

    }

    private static class MyObserverable extends Observable {
        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
