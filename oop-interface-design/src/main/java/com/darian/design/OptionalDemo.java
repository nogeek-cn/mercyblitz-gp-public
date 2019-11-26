package com.darian.design;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // 规避空指针问题
        Optional<String> optional = Optional.of("12.5");

        System.out.println(
                optional.map(Double::valueOf)
        );
    }
}
