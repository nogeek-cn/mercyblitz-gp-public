package com.darian.spring.webmvc.auto.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AutoConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /***
     * 配置类
     * @see SpringWebMvcConfiguration
     **/
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebMvcConfiguration.class};
    }

    /***
     * 这里我们映射所有的 Pattern
     */
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
