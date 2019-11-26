package com.darian.javaresource.jar;

import org.springframework.context.ApplicationContext;

import java.net.URL;

public class jarDemo {
    public static void main(String[] args) {
        // 装载这个类的文件
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL url = classLoader.getResource("META-INF/license.txt");
        System.out.println(url);
    }
}
