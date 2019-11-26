package com.darian.oopdesignpattern.decorate;


import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class DecoratorDemo {
    public static void main(String[] args) {
        // 被装饰者
        InputStream inputStream = null;
        // 装饰者
        FilterInputStream fileInputStream = new DataInputStream(inputStream);
        // DataInputStream -< FilterInputStream -< InputStream
        // DataInputStream(InputStream)
        // 子类重写父类的方法，并且可以添加新的方法。
    }
}
