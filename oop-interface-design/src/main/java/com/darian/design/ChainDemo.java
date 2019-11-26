package com.darian.design;


import java.util.LinkedList;
import java.util.List;

/***
 * 链式设计
 * 我第一个链条可以决定我第二个链条执不执行
 * Spring MVC handAdapter 也是这样子
 */
public class ChainDemo {
    // 执行者
    // chain
    public static void main(String[] args) {
        // 过滤器
        // 流水线 Pipeline
        // Stream 流式处理
        DefaluldExecutorChain chain = new DefaluldExecutorChain();
        chain.addExecutor(executorChain -> {
            System.out.println("Hello,world");
            // 执行链条中的下一个节点
            chain.execute();
        });

        chain.addExecutor(executorChain -> {
            System.out.println("ABC");
        });

        // 执行链
        chain.execute();

    }

    public static class DefaluldExecutorChain implements ExecutorChain {
        // [0] > [1]  >  [2]
        private final List<Executor> executorList = new LinkedList<>();
        // 当前执行的未知
        private int position = 0;

        // 增加链条上的节点
        private void addExecutor(Executor executor) {
            executorList.add(executor);
        }

        @Override
        public void execute() {
            int pos = position;
            Executor executor = executorList.get(pos);
            System.out.println("执行第 " + pos + " 个 executor 元素");
            position++;
            executor.execute(this);
        }
    }

    public interface Executor {
        void execute(ExecutorChain executorChain);
    }

    public interface ExecutorChain {
        void execute();
    }
}
