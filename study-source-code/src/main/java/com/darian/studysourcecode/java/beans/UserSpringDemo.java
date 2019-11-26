package com.darian.studysourcecode.java.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserSpringDemo {
    public static void main(String[] args) throws NamingException {


        /***
         * 没有 DataSource 定义
         */
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        DefaultListableBeanFactory beanFactory1 = new DefaultListableBeanFactory();
        beanFactory1.setParentBeanFactory(parentBeanFactory);

        /***
         * Spring
         */
        // xml 存一下
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        // 写法 1
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        User user1 = (User) beanFactory.getBean("user");
        // 写法 2
        User user = (User) applicationContext.getBean("user");
        applicationContext.getBean("user", User.class);

        /***
         * 传递相应的参数
         */
        beanFactory.getBean("user", 1L, "darian");

        /****
         * EJB
         */
        Context context = new InitialContext();
        /***
         * JNDI = Java Naming And Directory Interface
         * Tomcat 容器
         */
        Context context1 = (Context) context.lookup("java/com/");
        DataSource dataSource = (DataSource) context1.lookup("java/com/datasource");
    }
}
