package com.darian.spirngbootthymeleaf.demo;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class ThymeleafEngineDemo {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        TemplateEngine templateEngine = new SpringTemplateEngine();
        Properties properties = new Properties();
        properties.setProperty("name_zh_CN", "小诸葛");
        properties.setProperty("name_en", "dairan");

        // g国际化 i18n
        StandardMessageResolver messageResolver = new StandardMessageResolver();
        messageResolver.setDefaultMessages(properties);
        templateEngine.setMessageResolver(messageResolver);

        // 模板解析
        // Spring Resource  ->  Thymeleaf Template Resource
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String prefix = "classpath:/templates/thymeleaf";
        String suffix = ".html";
        String returnValue = "index";

        Resource templateResouce = resourceLoader.getResource(prefix + returnValue + suffix);


        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello, World");
        // 模板内容
        String content = StreamUtils.copyToString(templateResouce.getInputStream(), Charset.forName("UTF-8"));
//        "<p th:text=\"#{name}\">!!!</p>";
        // 渲染（处理）结果
        String result = templateEngine.process(content, context);

        System.out.println(result);
    }

}
