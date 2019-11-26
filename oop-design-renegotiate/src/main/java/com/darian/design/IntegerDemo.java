package com.darian.design;

import org.apache.commons.lang3.SystemUtils;

import java.util.Properties;

public class IntegerDemo {
    public static void main(String[] args) {
//        System.setProperty("AutoBoxCacheMax", "10");

        Integer value = 99;
        Integer value2 = new Integer(99);
        Integer value3 = Integer.valueOf(99);

        System.out.println("value equals value2: " + value.equals(value2));
        System.out.println("value equals value3: " + value.equals(value3));

        System.out.println("value == value2: " + (value == value2));
        System.out.println("value == value3: " + (value == value3));

    }
}
