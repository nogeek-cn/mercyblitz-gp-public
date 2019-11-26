package com.darian.oop.function.design;

/***
 * 面向对象编程
 */
public class OOPDemo {
    public static void main(String[] args) {
        // 面向过程
        int value = 10;
        // 数据（状态的变化）不在类里边，没有封装
        value += 1;

        Int i = new Int();
        // + 2
        // 所有的行为都有方法来描述
        i.add(2);
        System.out.println(i.value);

        // Utils 方法都是面向过程的。
        // GoF 23

        //常见： 工厂、抽象工厂、单例模式、共享（享元）模式、代理模式（静态、动态）、委派模式

        //常用： 装饰器模式、策略模式、模板模式、创建者模式、观察者模式、责任链模式

        //陌生： 访问者模式、调停者模式、桥接模式
    }

    private static class Int {
        // 数据
        // JAVA 语言规范规定了 int 的初始规范为 0
        private int value;

        private void add(int data) {
            this.value += data;
        }
    }
}
