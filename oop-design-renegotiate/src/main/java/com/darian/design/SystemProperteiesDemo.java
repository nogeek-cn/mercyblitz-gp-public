package com.darian.design;


import org.apache.commons.lang3.SystemUtils;

import java.util.Properties;

/***
 *  @see SystemUtils
 */
public class SystemProperteiesDemo {
    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        System.out.println(properties);
        /***
         * Properties extends Hashtable<Object,Object>
         *     它是线程安全的。Hashtable, 读和写的时候，都会有 Sysgnized
         *     System.getProperties() 尽可能地读一次
         *     可以参考 org.apache.commons.lang3.SystemUtils#FILE_ENCODING 的设计，
         *     通过常量来读取
         */
        System.err.println(System.getProperty("file.encoding"));


//        public static final String FILE_ENCODING = getSystemProperty("file.encoding");

    }
}