package com.darian.logbackdemo.logback;

import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.ConsoleAppender;

public class logbackDemo {
    public static void main(String[] args) {
//        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(logbackDemo.class);

        LoggerContext loggerContext = new LoggerContext();
        // 去 Cache 里边去取，如果存在就返回，没有的话，实例化一个
        Logger logger = loggerContext.getLogger(logbackDemo.class);
        // 添加控制台的日志附加器
        logger.addAppender(new ConsoleAppender<>());
        BasicConfigurator basicConfigurator = new BasicConfigurator();
        basicConfigurator.configure(loggerContext);
        logger.info("hello, logback");
    }
}

