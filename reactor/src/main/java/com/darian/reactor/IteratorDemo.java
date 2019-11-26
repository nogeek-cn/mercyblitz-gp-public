package com.darian.reactor;

import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        // 数据源
        // 这里是 JAVA 9 的 API
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);

        // 迭代
        // 消费数据
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){// 这个过程就是想服务器请求是否还有数据
            Integer value = iterator.next(); // 主动，获取数据
            System.out.println(value);
        }
    }
}
