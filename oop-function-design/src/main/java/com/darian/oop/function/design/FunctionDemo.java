package com.darian.oop.function.design;

import com.sun.xml.internal.ws.client.sei.ValueSetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/***
 * 函数式设计 Demo
 */
public class FunctionDemo {

    private static void demo(Supplier<List<Integer>> supplier) {
        // 1 - 10 并且把计算结果打印出来
        List<Integer> values = supplier.get();

        // 1 - 10 全部打印出来
        // Consumer —>> 只接收数据，不返回（消费数据）
        // Supplier  ->> 没有接受数据，只有返回（提供数据），引用方法和构造器
        // Predicate ——》》 判断
        // Function -> Integer -> integer * 2  转换

        // 1 - 10 挑选偶数

        // [1,2,3,4,5,6,7,8,9,10]  >>  [2,4,6,8,10] >> [4,8,12,16,20]
        // FlatMap 降低维度。
        values.stream().filter(value -> value % 2 == 0)  // Predicate 过滤 偶数
                .map(value -> value * 2)                 //  Function * 2
                .forEach(System.out::println);           //  Consumer


//        System.out.println(values.stream().reduce(0,Integer::sum));
    }

    private static void demoFlatMap() {

        // 二维降到一维
        // "A,B"  >>  ["A","B"]
        // "C,D,E"  >>  ["C","D","E"]

        Integer reduce = Arrays.asList("1,2", "3,4,5")
                .stream()
                // 一维变二维
                .map(s -> s.split(","))
                // "1,2"  >>  ["1","2"]
                .flatMap(strings -> Arrays.stream(strings))
                // ["1","2"] ["3","4","5"] => ["1","2","3","4","5"]
                .map(Integer::valueOf) // String -> Integer
                .reduce(1, Integer::sum);

        System.out.println(reduce);

//                .forEach(System.out::println); // Counsumer
    }

    public static void main(String[] args) {
//        demo(FunctionDemo::ontToTen);
        demoFlatMap();
    }

    private static List<Integer> ontToTen() {
        return range(1, 10);
    }

    private static List<Integer> range(int since, int count) {
        List<Integer> values = new ArrayList<Integer>(count);
        for (int i = since; i < since + count; i++) {
            values.add(i);
        }
        return values;
    }
}
