package com.darian.spring5webFluxdemo.web;


import io.netty.util.CharsetUtil;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;
import java.io.*;


@Controller
public class ResourceUtils {

    /***
     * jar 包中的文件的读的方法
     * @return
     */
    @GetMapping("/download_old")
    public ResponseEntity<byte[]> downloadInOldWays() {
        try {
            String codedFileName = "高血压.xlsx";
            String CONTENT_DISPOSITION = new String(("attachment; filename=" + codedFileName).getBytes(), CharsetUtil.ISO_8859_1);
            byte[] body = null;
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("ssss.xlsx");
            body = new byte[is.available()];
            is.read(body);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION)
                    .body(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("下载文件时报错");
        }
    }


    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.xls");

        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\ssss.xlsx");
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }

    /***
     * 读取系统中的资源
     * @return
     */
    public InputStream readSystemFile() throws IOException {
        byte[] body = null;
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        InputStream is = resourceLoader.getResource(System.getProperty("user.dir") + "\\src\\main\\resources\\ssss.xlsx")
                .getInputStream();
        body = new byte[is.available()];
        is.read(body);
        return is;
    }

    public static void main(String[] args) {
        ResourceUtils resourceUtils = new ResourceUtils();
        resourceUtils.downloadInOldWays();
    }
}
