package com.darian.reactor;

import com.darian.utils.PrintUtils;
import reactor.core.publisher.Flux;


public class FluxAPIDemo {
    public static void main(String[] args) {
        Flux.generate(() -> 0, (value, sink) -> {
            if (value == 3) {
                sink.complete(); // 主动完成
            } else {
                sink.next("value = " + value);
            }
            return value + 1;
        }).subscribe(PrintUtils::printlnFormart, PrintUtils::printlnFormart,() -> {
            PrintUtils.printlnFormart("Subscription is completed!!!");
        });
    }
}
