package com.darian.eurekaclosedsource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/25  23:13
 */
public class ApplicationContextDemo {

    public static void main(String[] args) {
        // 设置 父上下文
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext(SuperUser.class);

        // 构建一个注解驱动的应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setParent(parentContext);
        // 注册 UserConfiguration -》 User
        context.register(UserConfiguration.class);

        // 启动 Spring 应用上下文
        context.refresh();

        System.err.println(context.getBean(UserConfiguration.class));
        System.err.println(context.getBean(User.class));
        // 当前上下文 -> 找不到 -> parent 上下文
        // Spring MVC -> ContextLoaderListener -> Root WebApplicatin
        // Spring MVC -> DispatcherServlet -> Servlet WebApplication -> Parent == Root WebApplication
        // <context-param>  -> XML 文件，娶不到 dispatcher-servlet.xml
        // 父获取子的，自然取不到。
        // Bootstrap ClassLoader 完全无法感知 子 ClassLoader
        System.err.println(context.getBean(SuperUser.class));

        // 关闭 Spring 应用上下文
        context.close();
    }


    @Configuration
    public static class UserConfiguration {
        @Bean
        public User user() {
            return new User();
        }
    }
}
