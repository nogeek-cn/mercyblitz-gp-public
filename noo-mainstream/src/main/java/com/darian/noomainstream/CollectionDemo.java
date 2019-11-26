package com.darian.noomainstream;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;


public class CollectionDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                add();
            }).start();
        }
    }

    private static void add(){
        // 线程安全吗？
        Set<String> values = Collections.singleton("1");

        // 线程安全吗？
        Set<String> newValues = new ConcurrentSkipListSet<>();
        values.add("1");
        newValues.add("1");
    }
}
