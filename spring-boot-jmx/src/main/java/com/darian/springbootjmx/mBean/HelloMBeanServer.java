package com.darian.springbootjmx.mBean;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class HelloMBeanServer {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.darian.springbootjmx.mBean:type=Hello");
        mBeanServer.registerMBean(new Hello(), objectName);

        System.out.println("helloMBeanServer is starting......");

        Thread.sleep(Long.MAX_VALUE);

    }
}
