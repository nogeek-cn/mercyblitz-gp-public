package com.darian.flow;

import com.darian.utils.PrintUtils;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/***
 * JAVA 9 Flow API
 */
public class FlowDemo {
    public static void main(String[] args) throws InterruptedException {
        // 发布者
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>();) {
            // 订阅
            publisher.subscribe(new StringSubscriber("A"));
            publisher.subscribe(new StringSubscriber("B"));
            publisher.subscribe(new StringSubscriber("C"));

            publisher.submit("Hello, world");
        }

        // 主线程等待
        Thread.currentThread().join();
    }

    private static class StringSubscriber implements Flow.Subscriber<String> {
        private final String name;
        private Flow.Subscription subscription;

        private StringSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            PrintUtils.printlnFormart("订阅者 [ " + name + " ] 开始订阅！");
            // 向服务器反向请求
            subscription.request(1);
            this.subscription = subscription;
        }

        @Override
        public void onNext(String item) {
            PrintUtils.printlnFormart("订阅者 [ " + name + " ] 接收数据:" + item);
            if (new Random().nextBoolean() == false)
                throw new RuntimeException(".........runtime exce....");
//            else
//                subscription.cancel();
        }

        @Override
        public void onError(Throwable throwable) {
            PrintUtils.printlnFormart("订阅者 [ " + name + " ] 订阅异常：" + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            PrintUtils.printlnFormart("订阅者 [ " + name + " ] 完成订阅");
        }
    }
}
