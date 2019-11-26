package com.darian.spring5testdemo;


import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/***
 * JUnit 5
 */
public class JUnit5Demo {

    @BeforeAll
    public static void testBeffforeAll() {
        System.out.println("BeforeAll :准备数据源------------");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("Spring 5 :准备数据源------------");
    }

    @Test
    public void testHelloWorld() {
        System.out.println("helloworld ");
    }

    @Test
    public void testValue() {
        System.out.println("value");
    }


    @RepeatedTest(value = 5)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 5})
    public void test100Times(int ints) {
        System.out.println("test");
        Assert.assertTrue(ints > 1);

    }

}