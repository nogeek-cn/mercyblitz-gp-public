package com.darian.javai18ndemo.javase;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/***
 * {@link java.util.ResourceBundle}
 */
public class ResourceBundleDemo {
    public static void main(String[] args) throws IOException {
        // pachage(目录) + resource 名称（不包含 properties）
        String baseName= "static.default";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
        System.out.println("[bundle] name: " + bundle.getString("name"));

        ClassLoader classLoader = ResourceBundleDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("static/default_zh_CN.properties");
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        PropertyResourceBundle propertyResourceBundle = new PropertyResourceBundle(reader);
        System.out.println("[PropertyResourceBundle] name:"+ propertyResourceBundle.getString("name"));
    }

}
