package com.darian.javaresource.file;

import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class FileTohttpDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/application.properties");
        URL fileUrl = file.toURI().toURL();
        URLConnection urlConnection = fileUrl.openConnection();

        InputStream inputStreamFromURL = urlConnection.getInputStream();

        String context = StreamUtils.copyToString(inputStreamFromURL, Charset.forName("UTF-8"));
        System.out.println(context);
    }
}
