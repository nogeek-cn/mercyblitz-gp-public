package com.darian.springbehavioralpatternsdemo.Observer;


import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;


public class LifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyLifeCycle.class);

        context.addApplicationListener(event -> {
            if (event instanceof ContextStartedEvent)
                System.err.println("ContextStartedEvent...");
            if (event instanceof ContextStoppedEvent)
                System.err.println("ContextStoppedEvent...");
        });
        // context.register(......);
        // 启动 Spring 上下文
        context.refresh();

        System.err.println("在 start() 执行前：Spring 应用上下文是否运行：" + context.isRunning());

        // Spring 上下文也是 LifeCycle 的实现
        // 传播 start() 生命周期回调
        context.start();
        // 关闭 Spring 上下文

        System.err.println("在 start() 执行后：Spring 应用上下文是否运行：" + context.isRunning());

        context.stop();

        System.err.println("在 stop() 执行后：Spring 应用上下文是否运行：" + context.isRunning());

        // 传播 stop() 生命周期回调

        context.close();
    }


    public static class MyLifeCycle implements Lifecycle {

        private boolean running = false;
        @Override
        public void start() {
            running = true;
            System.err.println("MyLifeCycle.start()....");
        }

        @Override
        public void stop() {
            running = false;
            System.err.println("MyLifeCycle.stop()...");
        }

        @Override
        public boolean isRunning() {
            System.err.println("LifyCycle 状态....");
            return running;
        }
    }
}
