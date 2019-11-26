package com.darian.spring.webmvc.auto.config;

import com.darian.spring.webmvc.auto.annnotation.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/***
 * Spring Web MVC 配置 Bean
 */
@Configuration
@ComponentScan(basePackages = "com.darian.spring.webmvc.auto")
public class SpringWebMvcConfiguration {

    @ConditionalOnClass(String.class)
    @Bean("helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }

}
