package com.darian.proxydemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/27  4:13
 */
@RestController
public class IndexController {
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        return "{\n" +
                "\"status\":\"OK\",\n" +
                "\"msg\":\"成功\",\n" +
                "\"url\":\"/\"\n" +
                "}";
    }

    @GetMapping(value = "/abc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String abc() {
        return "{\n" +
                "\"status\":\"OK\",\n" +
                "\"msg\":\"成功\",\n" +
                "\"url\":\"/abc\"\n" +
                "}";
    }


}
