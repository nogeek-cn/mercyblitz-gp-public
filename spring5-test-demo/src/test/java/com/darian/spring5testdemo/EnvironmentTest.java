package com.darian.spring5testdemo;

import org.junit.jupiter.api.Test;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;

/***
 * Environment
 */
public class EnvironmentTest {

    @Test
    public void testGetProperty(){
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty("os.name", "Windows 7");

        System.out.println(environment.getProperty("os.name"));
        System.out.println(System.getProperty("os.name"));
    }

    @Test
    public void testStandardEnvironment(){
        // 标准实现会把我们的 环境变量给传进去 System  环境变量
        StandardEnvironment standardEnvironment = new StandardEnvironment();
        System.out.println(standardEnvironment.getProperty("TMP"));
        System.out.println(standardEnvironment.getProperty("os.name"));
    }
}