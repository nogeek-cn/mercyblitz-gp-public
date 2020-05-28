package com.darian.springcloudgatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
//@RestController
public class SpringCloudGatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayDemoApplication.class, args);
    }

    //@GetMapping("/fallback")
    //public String fallback() {
    //    return "fallback...";
    //}

    // webFlux: Function Endpoint
    @Bean
    public RouterFunction<ServerResponse> helloWorldRouteFunction() {
        return route(GET("/fallback"),
                request -> {
                    return ServerResponse.ok() // 200
                            .body(Mono.just("fallback...."), String.class);
                });
    }

    // Gateway Function Endpoint
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("rest-api",// id
                        r -> r.path("/rest-service/helloWorld")
                                .uri("http://localhost:8080/helloWorld"))
                .build();  // 返回 RouteLocator
    }
}
