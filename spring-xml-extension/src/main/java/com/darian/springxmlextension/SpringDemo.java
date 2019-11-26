package com.darian.springxmlextension;

import com.darian.springxmlextension.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {
        // 不需要调用 refresh() 方法。
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
