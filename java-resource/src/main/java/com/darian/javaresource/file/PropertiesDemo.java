package com.darian.javaresource.file;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String appName = properties.getProperty("spring.application.name");
        System.out.println(appName);

    }
}
