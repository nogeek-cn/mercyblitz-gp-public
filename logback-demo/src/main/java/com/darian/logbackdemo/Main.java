package com.darian.logbackdemo;

import ch.qos.logback.classic.Logger;

import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        StackTraceElement[] stackTraceElements = threadMap.get(thread);
        Stream.of(stackTraceElements).forEach( System.out::println);
    }

    public static void log(String args) {
//        Logger.info("message");
        // info -> appender
    }
}
