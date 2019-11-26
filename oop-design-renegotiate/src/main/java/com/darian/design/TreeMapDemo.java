package com.darian.design;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // 可以排序
        // 排序有个规则：通过传递 Comparator 实例、Key 可以排序
        TreeMap<Comparable, Object> treeMap = new TreeMap<>((o1, o2) -> 0);
        // Number (抽象类)：Integer、Long、Byte
        // comparable: String、Number(Integer、Long、Byte)
        treeMap.put(1, 1);
        treeMap.put(ByteBuffer.allocate(1), 2);

        eche(treeMap);

        HashMap<String, Object> map = new HashMap<>();
        map.put("Hello", "world");
        eche(map);

    }


    private static void eche(Map<?, ?> map) {
        System.out.println(map);
    }
}
