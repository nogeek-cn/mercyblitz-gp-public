package com.darian.lang;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.stream.Stream;

public class StringDemo {
    public static void main(String[] args) {
        Stream.of("as", "sdf", "12", "34", "23", "", null)
                .filter(Objects::isNull) // 方法是从 JAVA 8 开始的， Objects 是从 Java 7 开始的
                .filter(StringUtils::isNoneBlank)  // apache Commons langs
                .filter(StringUtils::isNumeric)
                .forEach(System.out::println);

        Stream.of("as", "sdf", "12", "34", "23", "", null)
                .filter(org.springframework.util.StringUtils::hasText)  // Spring framework
                .filter(StringUtils::isNumeric)
                .forEach(System.out::println);
    }
}
