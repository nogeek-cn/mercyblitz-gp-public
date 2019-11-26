package com.darian.javaresource.http;


import org.springframework.http.HttpMethod;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;


public class httpDemo {
    public static void main(String[] args) throws IOException {
        // URL https://start.spring.io/

//        RestTemplate restTemplateFromtemplate = new RestTemplate();
//        InputStream inputStreamFromRestTemplate = restTemplateFromtemplate.execute("https://start.spring.io/",
//                HttpMethod.GET,
//                request -> {
//                },
//                Response -> Response.getBody());
//        // 正常来说应该从相应体里边拿出来
//        InputStreamReader reader = new InputStreamReader(inputStreamFromRestTemplate, "UTF-8");
//        System.out.println(reader);
//
        URL url = new URL("https://start.spring.io/");      // https
        URL ftpurl = new URL("ftp://ftp.baidu.com");        // ftp
        URL jarurl = new URL("jar://jar.baidu.com");        // jar 协议
        URL wetchat = new URL("webchat://...");             // 微信协议
        URL dubboURL = new URL("dubbo://...");              // dubbo 协议
        URL classpathURL = new URL("classpath:/");          /// classpath

        InputStream inputStreamFromURL = url.openStream();

        String context = StreamUtils.copyToString(inputStreamFromURL, Charset.forName("UTF-8"));
        System.out.println(context);
    }
}
