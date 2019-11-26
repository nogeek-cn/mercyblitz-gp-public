package com.darian.design;

import java.util.logging.Logger;

public class LoggerDemo {
    static {
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        System.out.println("world");
        // 举反例
        // 这个类的加载顺序不一定由你的程序来控制
        // 类加载
        System.setProperty("java.util.loggin.config.file",
                "D:\\GuPao_IDEA_xiaomage_workspace\\GP-public\\oop-design-renegotiate\\src\\main\\resources\\logging.properties");
        Logger logger = Logger.getLogger("com");
        logger.info("hello, world");
    }
}
