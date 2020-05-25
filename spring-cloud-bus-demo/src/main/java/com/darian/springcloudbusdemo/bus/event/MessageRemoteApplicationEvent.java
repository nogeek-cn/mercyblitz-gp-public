package com.darian.springcloudbusdemo.bus.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/***
 * 自定义消息-消息远程事件
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/26  4:00
 */
public class MessageRemoteApplicationEvent extends RemoteApplicationEvent {

    private MessageRemoteApplicationEvent() {
        // 为了 JSON 序列化
    }

    public MessageRemoteApplicationEvent(String source, String originService, String destinationService) {
        super(source, originService, destinationService);
    }

    public String getMessage() {
        return (String) getSource();
    }
}
