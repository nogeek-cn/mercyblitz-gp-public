package com.darian.springcloudbusdemo;

import com.esotericsoftware.kryo.util.ObjectMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;

/***
 * Jackson 是 Json 序列化/反序列化框架
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/26  3:56
 */
public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 创建一个 RefreshRemoteApplicationEvent
        String message = "Hello, world";
        String originService = "user-service";
        String destinationService = "email-service";
        RefreshRemoteApplicationEvent event = new RefreshRemoteApplicationEvent(message, originService, destinationService);
        // 序列化 JSON
        String json = objectMapper.writeValueAsString(event);
        System.out.println(json);
    }
}
