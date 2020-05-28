package helloworld.com.darian.java9.helloWorld;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.logging.Logger;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/28  9:16
 */
public class HelloWorldMain {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger(HelloWorldMain.class.getName());
        logger.info("xxx");
        System.out.println("Hello, World");

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getUptime());

        Thread.sleep(33333);
    }
}
