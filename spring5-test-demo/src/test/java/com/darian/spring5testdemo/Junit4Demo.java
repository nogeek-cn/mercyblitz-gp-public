package com.darian.spring5testdemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/***
 * JUnit 4 测试
 */
public class Junit4Demo {

    /***
     * Before 是我们的方法，每一次执行方法前都会调用
     */
    @Before
    public void prepare() {
        System.out.println("准备数据源--");
    }


    @Test
    public void testHelloWorld() {
        System.out.println("helloworld ");
    }

    @Test
    public void testValur() {
        System.out.println("Value");
    }

    @After
    public void destory() {
        System.out.println("关闭数据源");
    }

    @Test
    public void test100Times() {
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(i > -1);
        }
    }
}
