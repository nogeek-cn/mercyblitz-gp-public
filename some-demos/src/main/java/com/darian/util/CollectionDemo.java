package com.darian.util;

import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import org.apache.commons.collections.CollectionUtils;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CollectionDemo {
    public static void main(String[] args) {
        List<String> stringList = List.of("2", "3", "4");// since 9
        // java.lang.UnsupportedOperationException
        //stringList.add("4");   // ImmutableCollections 不变的

        System.out.println(CollectionUtils.isNotEmpty(stringList)); // apache Commons Collections
        System.out.println(CollectionUtils.isFull(stringList));  // apache

        System.out.println(org.springframework.util.CollectionUtils.isEmpty(stringList)); // Spring framework
        Map<String, String> maps = Map.of("A","A","c","c");
        System.out.println(org.springframework.util.CollectionUtils.isEmpty(maps));

        // 使用场景有关系
        // Spring Framework < Apache commons lang（<=4 的时候依赖）
        // Spring Framework <5  => Apache commons logging(不再需要了)
        // Spring Frameowrk >=5  -> Spring JCL
        // Apache Commons Lang 2.4 & 2.6 会有一些不兼容
    }

    {
        // Effective Java II   都是不变的对象
        EnumSet<TimeUnit> timeUnits =
                EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS);
    }
}
