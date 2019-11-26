package com.darian.studysourcecode.java.beans;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownServiceException;

public class UserBeanSpringDemo {
    // <Bean id="user" class="com......">
    //      <property id="id" value>
    //      <pro....
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = null;
        Class userClass = classLoader.loadClass("com.darian.studysourcecode.java.beans.User");
        Constructor constructor = userClass.getConstructor();
        User user2 = (User) constructor.newInstance();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 理解 Bean 定义 = BeanDefinition
        // XML = BeanDefinition
        // Annotation 也是 BeanDefinition   AnnotationBeanDefinition 是 2.5 以后的。
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // User Bean 定义
        // 编码的方式定义。
        AbstractBeanDefinition userBeanDefinition = builder.getBeanDefinition();
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        // <property name="id" value="1L">
        propertyValues.add("id", 1L);
        // <property name="name" value="darian ">
        propertyValues.add("name", "darian");
        userBeanDefinition.setPropertyValues(propertyValues);
        // 注册
        beanFactory.registerBeanDefinition("user", userBeanDefinition);
        User user = beanFactory.getBean(User.class);
        System.out.println(user);

    }
}
