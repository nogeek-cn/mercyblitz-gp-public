package com.darian.easystudyspring;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class DefaultResourceLoaderDemo {
    public static void main(String[] args) throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        resourceLoader.addProtocolResolver((location, resourceLoader1) -> {
            if (location.startsWith("darian://"))
                return new ClassPathResource(location.substring("darian://".length()));
            return null;
        });

        Resource resource = resourceLoader.getResource("darian://application.properties");

        String resoureString = StreamUtils.copyToString(resource.getInputStream(),
                Charset.forName("UTF-8"));
        System.out.println(resoureString);

    }
}
