package com.darian.proxydemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a>
 * @date 2020/5/27  3:57
 */
@WebServlet(name = "proxy", urlPatterns = "/proxy/*")
public class ProyServlet extends HttpServlet {

    // Proxy -> POST GET
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求头，请求体
        // header、Body

        // Client(Header + Body proxy forward => IP.PORT)
        // X-forwarded-For如果请求套存在，使用该值
        //Client 127.0.0.1 ->Proxy(168.0.0.)
        // httpServletRequest -> HttpClient > 192.0.0.1

        // 转发客户端
        RestTemplate restTemplate = new RestTemplate();

        // 执行请求到目标服务器(支持https)
        // 当前端口 8080
        // 目标服务器
        String RootURL = "http://www.baidu.com";
        RootURL = "http://localhost:8080";


        // 可以通过我的应用名称反向的寻找我的服务列表

        // Accept:  Request -> http://localhost:8080/abc -> RequestURI + "/abc"
        // target URL  => http://localhost:9090/abc
        String targetURL = RootURL + request.getRequestURI().substring("/proxy".length());
        // 构造 Request 实体
        RequestEntity requestEntity = null;
        try {
            requestEntity = createRequestEntity(request, targetURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        ResponseEntity<byte[]> responseEntity = restTemplate
                .exchange(requestEntity, byte[].class);

        wirteHeaders(responseEntity, response);
        writeBody(responseEntity, response);


    }

    private RequestEntity<byte[]> createRequestEntity(
            HttpServletRequest request, String url) throws URISyntaxException, IOException {
        String method = request.getMethod();
        HttpMethod httpMethod = HttpMethod.resolve(method);
        byte[] body = createRequestEntity(request);
        MultiValueMap<String, String> headers = createRequestHeaders(request);
        RequestEntity<byte[]> requestEntity = new RequestEntity(body, headers, httpMethod, new URI(url));

        return requestEntity;
    }


    private MultiValueMap<String, String> createRequestHeaders(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();

        ArrayList<String> headerNames = Collections.list(request.getHeaderNames());
        for (String headerName : headerNames) {
            ArrayList<String> headerValues = Collections.list(request.getHeaders(headerName));

            for (String headerValue : headerValues) {
                headers.add(headerName, headerValue);
            }
        }
        return headers;
    }

    private byte[] createRequestEntity(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        return StreamUtils.copyToByteArray(inputStream);
    }


    private void preparedHeaders(HttpServletRequest request,
                                 RequestEntity<byte[]> requestEntity) {
        // 准备请求头
        HttpHeaders headers = requestEntity.getHeaders();

        List<String> headerNames = Collections.list(request.getHeaderNames());

        for (String headerName : headerNames) {
            List<String> headerValues = Collections.list(request.getHeaders(headerName));
            for (String headValue : headerValues) {
                headers.add(headerName, headValue);
            }
        }
    }


    /**
     * 输出 Body 部分
     *
     * @param responseEntity
     * @param response
     * @throws IOException
     */
    private void writeBody(ResponseEntity<byte[]> responseEntity,
                           HttpServletResponse response) throws IOException {
        if (responseEntity.hasBody()) {
            byte[] body = responseEntity.getBody();
            // 输出二进制值
            ServletOutputStream servletOutputStream = response.getOutputStream();
            // 输出 ServletOutputStream
            servletOutputStream.write(body);
            servletOutputStream.flush();

        }
    }

    private void wirteHeaders(ResponseEntity<byte[]> responseEntity,
                              HttpServletResponse httpServletResponse) {
        // 获取响应的头
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        // 输出转发 Response 头
        for (Map.Entry<String, List<String>> entry : httpHeaders.entrySet()) {
            String headerName = entry.getKey();
            List<String> headerValues = entry.getValue();

            for (String headerValue : headerValues) {
                httpServletResponse.addHeader(headerName, headerValue);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        // 创建转发客户端
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity requestEntity = new RequestEntity(HttpMethod.GET, new URI("http://www.baidu.com"));
        ResponseEntity<byte[]> responseEntity = restTemplate.exchange("http://www.baidu.com",
                HttpMethod.GET,
                requestEntity,
                byte[].class);

        System.err.println("responseEntity : \n" + responseEntity);
        System.err.println("responseEntity.getBody() : \n" + new String(responseEntity.getBody()));

    }
}
