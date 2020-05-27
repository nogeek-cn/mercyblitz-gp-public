package com.darian.proxydemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/27  4:59
 */
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "com.darian.proxydemo.controller") // 扫描 Controller
public class ZuulProxyBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulProxyBootstrap.class)
                .properties("server.port=9090") // 9090
                .properties("zuul.routes.proxy-servlet.path=/proxy-servlet/**") // 设置
                .properties("proxy-servlet.ribbon.listOfServers=localhost:8080")
                .run(args);
    }
}
