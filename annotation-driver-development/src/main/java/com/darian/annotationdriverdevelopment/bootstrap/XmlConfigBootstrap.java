package com.darian.annotationdriverdevelopment.bootstrap;

import com.darian.annotationdriverdevelopment.demain.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * XML 配置引导类
 */
public class XmlConfigBootstrap {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext();
        context.setConfigLocation("classpath:/META-INF.spring/context.xml");

        context.refresh();
        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}
