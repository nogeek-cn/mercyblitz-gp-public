package com.darian.springbootjmx.dynamicBean;

import javax.management.DynamicMBean;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

public class DynamicBeanServer {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.darian.springbootjmx.dynamicBean:type=Data");

        Data data = new DefaultData();
        DynamicMBean dynamicMBean = new StandardMBean(data, Data.class);
        mBeanServer.registerMBean(dynamicMBean, objectName);

        System.out.println("DynamicBeanServer start ......");
        Thread.sleep(Long.MAX_VALUE);
    }
}
