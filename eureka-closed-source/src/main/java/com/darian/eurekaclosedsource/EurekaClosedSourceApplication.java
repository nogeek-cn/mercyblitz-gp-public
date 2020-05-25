package com.darian.eurekaclosedsource;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class EurekaClosedSourceApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EurekaClosedSourceApplication.class, args);
        new SpringApplicationBuilder(EurekaClosedSourceApplication.class)
                .parent(new AnnotationConfigApplicationContext())
                .web(WebApplicationType.NONE) // 非 Web 程序
                .properties("name=darian")
                .run(args);
    }

    // parent 上下文: 注册 A Bean
    // Current 上下文： 注册 B Bean




}


