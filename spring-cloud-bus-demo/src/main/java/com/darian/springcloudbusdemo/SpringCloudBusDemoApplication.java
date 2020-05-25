package com.darian.springcloudbusdemo;

import com.darian.springcloudbusdemo.bus.event.MessageRemoteApplicationEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.config.BinderFactoryConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RemoteApplicationEventScan(basePackageClasses = MessageRemoteApplicationEvent.class)
public class SpringCloudBusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusDemoApplication.class, args);
    }

}
