package com.darian.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  20:37
 */
public class CollectionFactoryMethodDemo {
    public static void main(String[] args) {
        Set<String> words = Set.of("Hello", "World");
        words.forEach(System.out::println);

        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integers.stream().reduce(Integer::sum).get();
        System.out.println(sum);

        sum = integers.stream().parallel().reduce(Integer::sum).get();
        System.out.println(sum);
    }


    private <T> Set<T> of(T... values) {
        Set<T> set = new HashSet<>();
        Stream.of(values).forEach(value -> {
            set.add(value);
        });
        return set;
    }
}
