package com.darian.spring5testdemo;

import junit.framework.TestCase;
import org.junit.Test;

public class JUnit3Demo extends TestCase {

    @Override
    protected void setUp() throws Exception {
        System.out.println("准备数据源");
        System.out.println();
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("关闭数据源");
        System.out.println();
    }

    @Test
    public void testHelloWorld(){
        System.out.println("helloworld ");
    }
}
