package com.darian.studysourcecode.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class UserDemo {

    // Spring 也是类似的实现
    private Map<String, Object> beansMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IntrospectionException {
        // Field 字段（不一定有 setter 或者 getter 方法）
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        Stream.of(propertyDescriptors).forEach(System.out::println);
    }
}
