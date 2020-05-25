package com.darian.springcloudbusdemo.web.controller;

import com.darian.springcloudbusdemo.bus.event.MessageRemoteApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 * 消息事件 {@link Controller}
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/26  4:04
 */
@RestController
public class MessageEventController
//        implements ApplicationListener<MessageRemoteApplicationEvent>
{

    @Value("${spring.application.name}")
    private String originService;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/send/sync/event")
    public MessageRemoteApplicationEvent syncEvent(
            @RequestParam String message,
            @RequestParam String destinationService) {
        MessageRemoteApplicationEvent event =
                new MessageRemoteApplicationEvent(message, applicationContext.getId(), destinationService);

        applicationContext.publishEvent(event);
        return event;


        // 目标地址
        // destinationService = localhost:8081
        // http://localhost:8081
//        String url = "http://" + destinationService + "/reveive/sync/event";
//        return restTemplate.postForObject(url, event, MessageRemoteApplicationEvent.class);
    }

    /**
     * 接受 {@link MessageRemoteApplicationEvent} 并且返回
     *
     * @param event
     * @return
     */
    @PostMapping("/reveive/sync/event")
    public MessageRemoteApplicationEvent receiveSyncEvent(
            @RequestBody MessageRemoteApplicationEvent event) {
        return event;

    }

//    @Override
//    public void onApplicationEvent(MessageRemoteApplicationEvent event) {
//        System.err.println(event);
//    }
}
