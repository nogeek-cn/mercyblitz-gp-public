package com.darian.springbehavioralpatternsdemo.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class BeanDefinitionBuilderDemo {
    public static void main(String[] args) {
//        createByStaticFacotry();
        createByfactory(BeanDefinition.SCOPE_SINGLETON);
        createByfactory(BeanDefinition.SCOPE_PROTOTYPE);

    }


    public static void createByStaticFacotry(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Marker.class);
        builder.setFactoryMethod("createMarker");
        /***
         * 创建 BeanDefinition
         */
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        // 创建 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册 BeanDefinition, 并以 “marker” Bean 名称
        beanFactory.registerBeanDefinition("marker", beanDefinition);
        // 或者 Marker bean
        System.out.println(beanFactory.getBean("marker", Marker.class) == beanFactory.getBean("marker", Marker.class));
    }


    public static void createByfactory(String scope){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Marker.class);
        builder.setScope(scope);
        builder.addConstructorArgValue("hello, world");
        /***
         * 创建 BeanDefinition
         */
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        // 创建 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册 BeanDefinition, 并以 “marker” Bean 名称
        beanFactory.registerBeanDefinition("marker", beanDefinition);
        // 或者 Marker bean
        System.out.println(beanFactory.getBean("marker", Marker.class) == beanFactory.getBean("marker", Marker.class));
    }

    /***
     * 方法定义
     * @return
     */
    @Bean
    public Object object(){
        return new Object();
    }

    /***
     * 类定义
     */
    @Component
    public static class MyComponent{
    }

    /***
     * 编码定义
     */
    @Data
    @AllArgsConstructor
    public static class Marker{
        private String name;

        public static Marker createMarker(){
            return new Marker("Create static method");
        }
    }


}
