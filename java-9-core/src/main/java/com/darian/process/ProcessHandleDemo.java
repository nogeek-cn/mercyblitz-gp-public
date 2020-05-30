package com.darian.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.security.PublicKey;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  20:50
 */
public class ProcessHandleDemo {
    public static void main(String[] args) {
        echoOnExit();
        echoAllProcessors();
    }

    private static void echeCurrentProcessonExit() {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> {
                    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
                    String value = runtimeMXBean.getName(); // value=pid@xxx

                    String pid = value.substring(0, value.indexOf("@"));

                    
                    System.out.println("Current [" + ProcessHandle.current().pid()
                            + "]Process while on Exit! ");
                }));
    }

    private static void echoOnExit() {
        ProcessHandle.current()
                .onExit()
                .thenAccept(System.out::println);
    }

    private static void echoAllProcessors() {
        ProcessHandle.allProcesses().forEach(System.out::println);
    }
}
