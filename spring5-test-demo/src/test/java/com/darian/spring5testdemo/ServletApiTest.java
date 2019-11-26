package com.darian.spring5testdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/***
 * Servlet API 测试
 */
public class ServletApiTest {

    @Test
    public void testHttpServletRequestInDynamicMock(){
        // 动态代理
        HttpServletRequest request = mock(HttpServletRequest.class);
        System.out.println(request);

        // 当需要调用 HttpServletRequest#getParameter 时，并且参数名称为 "name"
        when(request.getParameter("name")).thenReturn("darian");

        String name = request.getParameter("name");
        assertEquals("darian", name);


    }

    @Test
    public void testHTTPServletRequestInStaticMock(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name","darian");

        // 获取请求参数
        // 没有 Web 服务，也没有 Tomcat, 也没有 Spring Boot
        String name = request.getParameter("name");
        assertEquals("darian",name);
    }
}