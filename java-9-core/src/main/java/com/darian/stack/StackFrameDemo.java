package com.darian.stack;

import java.util.stream.Stream;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  21:32
 */
public class StackFrameDemo {
    public static void main(String[] args) {

        // before Java 9
        echoStackTranceElement();


        // Java 9
        echoStackWalker();

        }

    private static void echoStackTranceElement() {
        Stream.of(Thread.currentThread().getStackTrace())
                .forEach(System.err::println);
    }

    private static void echoStackWalker() {
        StackWalker.getInstance().forEach(System.out::println);
    }


}
