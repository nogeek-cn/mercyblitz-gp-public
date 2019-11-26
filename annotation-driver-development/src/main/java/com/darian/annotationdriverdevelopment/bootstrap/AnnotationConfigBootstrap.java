package com.darian.annotationdriverdevelopment.bootstrap;

import com.darian.annotationdriverdevelopment.config.UserConfiguration;
import com.darian.annotationdriverdevelopment.demain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * Annotation 配置引导类
 * 替换 XML 配置
 */
public class AnnotationConfigBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 需要注册一个 UserConfiguration 的 Bean
        context.register(UserConfiguration.class);

        context.refresh();
        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}
