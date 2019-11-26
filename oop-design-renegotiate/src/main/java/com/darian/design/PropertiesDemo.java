package com.darian.design;

import org.apache.commons.lang3.SystemUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("default.properties");
        // 引起乱码
        // properties.load(inputStream);
        // 适配器模式（前者转换后者，然后适配后者接口）  inputStream  -> Reader
        // 装饰器模式(两者具备相同的父接口)  InputStream  -> ByteInputStream
        // InputStreamReader 三个重载构造器
        InputStreamReader reader = new InputStreamReader(inputStream, SystemUtils.FILE_ENCODING);
        // 入参尽量保证接口或者抽象类（抽象类不够抽象，因为它有实现）
        properties.load(reader);
        // 好的面向对象的设计通常存在方法重载，提供不同的来源渠道
        System.out.println(properties.get("name"));
    }
}
