package com.darian.javaresource.classpath;



import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class ClasspathDemo {
    public static void main(String[] args) throws IOException {
        // Spring Classpath protocol
        // classpath:/META-INF/license.txt
        URL url = new URL("classpath:/META-INF/license.txt");

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String context = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
        System.out.println(context);
    }
}
