package concurrent.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/***
 * {@link java.util.concurrent.SubmissionPublisher}
 */
public class SubmissionPublisherDemo {
    public static void main(String[] args) throws InterruptedException {
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
            publisher.subscribe(new IntegerSubscriber("A"));
            publisher.subscribe(new IntegerSubscriber("B"));
            publisher.subscribe(new IntegerSubscriber("C"));

            CompletableFuture<Void> completableFuture = publisher.consume(integer -> {
                System.out.println("[" + Thread.currentThread().getName() + "]:" + integer);
            }).thenRunAsync(() -> System.out.println("[" + Thread.currentThread().getName() + "]"))
                    .thenRun(() -> System.out.println("[" + Thread.currentThread().getName() + "]"))
                    .exceptionally(throwable -> {
                        System.out.println(throwable);
                        return null;
                    });

            // 提交数据到各个订阅器
            publisher.submit(100);
        }
//        publisher.close();
        Thread.currentThread().join(5000);
    }

    private static class IntegerSubscriber implements Flow.Subscriber<Integer> {
        private final String name;
        private Flow.Subscription subscription;

        public IntegerSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            System.out.println("Thread:[" + Thread.currentThread().getName() + "]:"
                    + "Surrent Subscriber:[" + name + "]"
                    + "subscribes subscription:[" + subscription + "]");
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            System.out.println("Thread:[" + Thread.currentThread().getName() + "]:"
                    + "Surrent Subscriber:[" + name + "]"
                    + "receives item:[" + item + "]");
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println(throwable);
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println("Thread:[" + Thread.currentThread().getName() + "]:"
                    + "is complete:[" + name + "]");
        }
    }
}
