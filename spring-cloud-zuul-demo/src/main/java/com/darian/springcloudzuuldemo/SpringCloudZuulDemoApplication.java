package com.darian.springcloudzuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulDemoApplication.class, args);
    }

}
