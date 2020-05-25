package com.darian.springcloudbusdemo;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * XML 形式的 Application Demo
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/26  3:14
 */
public class XmlApplicationContextDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext();

        xmlApplicationContext.addApplicationListener(event -> {
            if (event instanceof PayloadApplicationEvent) {
                PayloadApplicationEvent payloadApplicationEvent = PayloadApplicationEvent.class.cast(event);
                System.err.println(payloadApplicationEvent.getPayload());
            } else {
                System.err.println(event);
            }
        });

        xmlApplicationContext.refresh();
        // Spring 萨汗国那下文是一个 事件发布器，非 ApplicationEvent, 是 PayLoadApplicationEvent
        xmlApplicationContext.publishEvent("Hello, World!");
        xmlApplicationContext.publishEvent(156456);

    }
}
