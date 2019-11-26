package com.darian.oop.function.design;

import org.omg.CORBA.CustomMarshal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/***
 * 累加求和
 */
public class SumDemo {

    // Java 8 面向函数计算方式，
    // 通过面向对象的方式（Function 是接口）
    // 语法补充，你可以执行代码或者方法引用
    public static int sumInJava8(int size, BinaryOperator<Integer> function) {
        List<Integer> values = range(1, size);
        int sum = 0;
        return values.stream().reduce(sum, function);
    }


    public static void main(String[] args) {
//        int sum = sumInJava5(10, new Sum() {
//            @Override
//            public int calc(int a, int b) {
//                return a + b;
//            }
//        });
//        System.out.println(sum);

        // 方法引用的时候需要签名一样，保证方法参数和返回值一样就可以了。
        int sum = sumInJava8(10, Integer::sum);
    }

    private static int suminJava8(int size) {
        List<Integer> values = range(1, size);
        // <U> U reduce(U identity,
        //                 BiFunction<U, ? super T, U> accumulator,
        //                 BinaryOperator<U> combiner)
        int sum = 0;
        // values = [1,2,3,4,5,6,7,8,9,10]
        // stream 流式
        // values = [(1,2),3,4,5,6,7,8,9,10]
        //  =>  (1,2),3,4,5,6,7,8,9,10
        //  =>  (3,3),4,5,6,7,8,9,10
        // Stream API
        // 方法引用

        // C 里边
        // using std;
        // usd::cout  => cout
        return values.stream().reduce(sum, Integer::sum);
    }

    public static int calclate(int a, int b) {
        return a + b;
    }

    private static class SumImpl implements Sum {

        @Override
        public int calc(int a, int b) {
            return a + b;
        }
    }

    private interface Sum {
        /***
         * 计算方法
         * @param a 左值
         * @param b 右值
         * @return 计算值
         */
        int calc(int a, int b);
    }

    // 面向对象
    private static int sumInJava5(int size, /*计算方法*/Sum sum) {
        // 变量参数， （Java 5）
        // 后边没有 Integer 是 JAVA 7 的语法。
        List<Integer> values = range(1, size);
        //Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = 0;

        // 迭代器、泛型
        Iterable<Integer> integers = values;
        // 迭代语句（Java 5）
        for (Integer value : integers) {
            // 这里的计算过程不是面向对象的
            // result += value;
            // 现在就是面向对象
            result += sum.calc(result, value); // Unboxing Integer -> int (JAVA 5)
        }
        return result;
    }

    // 面向过程
    private static void sumcommon() {
        // Java 和 C 没什么区别
        int count = 10;
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static List<Integer> range(int since, int count) {
        List<Integer> values = new ArrayList<Integer>(count);
        for (int i = since; i < since + count; i++) {
            values.add(i);
        }
        return values;
    }
}
