package com.darian.reactor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxDemo {
    public static void main(String[] args) {
        reactor();
        forEach();
    }

    public static void reactor() {
        long start = System.currentTimeMillis();
        Flux.just(1, 2, 3).subscribe(System.out::println);
        System.out.println("reactor 耗时：" + (System.currentTimeMillis() - start));
    }

    public static void forEach() {
        long start = System.currentTimeMillis();
        Stream.of(1, 2, 3).forEach(System.out::println);
        System.out.println("forEach 耗时：" + (System.currentTimeMillis() - start));
    }

//    @ConfigurationProperties("user")
    public static class User{
        private List<String> addresses;
    }
    // user.addresses[0]=A
    // user.addresses[1]=B

}
