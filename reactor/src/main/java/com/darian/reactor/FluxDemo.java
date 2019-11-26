package com.darian.reactor;

import com.darian.utils.PrintUtils;
import reactor.core.publisher.Flux;

import java.lang.invoke.VarHandle;
import java.util.Random;

/***
 * {@link reactor.core.publisher.Flux}
 */
public class FluxDemo {
    public static void main(String[] args) {
        Random random = new Random();
        // 订阅并且处理（控制台输出）
        Flux.just(1, 2, 3, 4, 5, 6, 7)
                .map(integer -> {
                    // 当 随机数 == 3 抛出异常
                    if (random.nextInt(8) == 3) {
                        throw new RuntimeException("integer ==3");
                    }
                    return integer + 1;
                })
                .subscribe(
                        PrintUtils::printlnFormart,     // 处理数据  onNext()
                        PrintUtils::printlnFormart,     // 处理异常  onError()
                        () -> PrintUtils.printlnFormart("Subscription is completed!!")
                );
    }
}
