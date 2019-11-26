package com.darian.javaresource.spring.resource;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        // Resource
        // FileSystemResource
        // ClassPathResource
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        // 添加一个 cp 协议的处理
        resourceLoader.addProtocolResolver((location, resourceLoader1) -> {
            String PROTOCOL_PREFIX = "cp:/";
            if (location.startsWith(PROTOCOL_PREFIX)) {
                String classpath = ResourceLoader.CLASSPATH_URL_PREFIX
                        + location.substring(PROTOCOL_PREFIX.length());
                return resourceLoader1.getResource(classpath);
            } else {
                return null;
            }
        });

        Resource resource = resourceLoader
                .getResource("cp:/application.properties");


        InputStream inputStream = resource.getInputStream();
        String content = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(content);
    }
}
