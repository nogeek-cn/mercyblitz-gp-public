package com.darian.restserviceproviderdemo.reactive.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a>
 * @date 2020/5/27  10:13
 */
@Configuration
@Slf4j
public class ReactiveWebEndpointConfiguration {

    @GetMapping("/helloWorld_1")
    @ResponseBody
    public String helloWorld() {
        return "hello, world!";
    }

    /**
     * Response
     * -- status = "200"
     * -- body = "hello, world";
     * HTTP Method = GET
     * HTTP URI = /helloWorld
     * Q: 这比传统 Controller 优势在哪里
     * --
     * return ServerResponse
     * Reactor
     * Publish -> Mono(0,1) | Flux(0,n)
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorldRouteFunction() {
        return route(GET("/helloWorld"),
                request -> {
                    waitAWhile(200);
                    return ServerResponse.ok() // 200
                            .body(Mono.just("Hello, world"), String.class);
                });
    }

    private void waitAWhile(int time) {
        long randomInt = new Random().nextInt(time);

        try {
            TimeUnit.MILLISECONDS.sleep(randomInt);
            log.info("sleep: " + randomInt + "  ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}