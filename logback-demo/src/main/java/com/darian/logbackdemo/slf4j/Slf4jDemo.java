package com.darian.logbackdemo.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {
    public static void main(String[] args) {
        // 类会决定全路径名称，和 Slf4jDemo.class 和 Slf4jDemo.class.getName() 一摸一样的
        // 在重载方法一样都是一样的
        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
        logger.info("Hello, slf4j");
    }
}
