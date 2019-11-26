package com.darian.spring5webFluxdemo.web.webConfiguration;

import com.darian.spring5webFluxdemo.domain.User;
import com.darian.spring5webFluxdemo.repository.UserRepository;
import com.darian.spring5webFluxdemo.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import static reactor.core.publisher.Mono.*;

@Configuration
@RequiredArgsConstructor
public class WebFluxConfiguration {
    private final UserRepository userRepository;

    @Bean
    public RouterFunction helloWorldFlux() {
        // 一个是 Request 的映射，匹配规则
        RequestPredicate requestPredicate = GET("/webflux");
        HandlerFunction handlerFunction = new HandlerFunction() {
            // 处理请求
            @Override
            public Mono handle(ServerRequest serverRequest) {
                return ok().body(just("hello, world"), String.class);
            }
        };
        return route(requestPredicate, handlerFunction);
    }

    @Bean
    public RouterFunction helloworldFlux() {
        return route(GET("/webflux1"), request ->
                ok().body(just("hello,world"), String.class));
    }

    @Bean
    public RouterFunction hello() {
        return route(GET("/webflux2"), serverRequest -> {
            Optional<String> messages = serverRequest.queryParam("messages");
            return ok().body(just(messages.get()), String.class);
        });
    }

    @Bean
    public RouterFunction personRouterFunction() {
        return route(POST("/webflux/user"), serverRequest ->
                ok().body(
                        serverRequest.bodyToMono(User.class)
//                                .subscribeOn(Schedulers.parallel())
                                .map(User::toString),
                        String.class));
    }

    @Bean
    public RouterFunction UserRouterFuction() {
        return route(POST("/flux/user/add"), serverRequest ->
                ok().body(serverRequest.bodyToMono(User.class)
                                .map(user -> userRepository.saveUser(user))
                                .map(ApiResponse::apiResponseOk),
                        ApiResponse.class))
                .andRoute(GET("/flux/user/getall"), serverRequest ->
                        ok().body(just(userRepository.findAll())
                                        .map(ApiResponse::apiResponseOk),
                                ApiResponse.class))
                .andRoute(POST("/flux/user/update"), serverRequest ->
                        ok().body(serverRequest.bodyToMono(User.class)
                                        .map(user -> userRepository.update(user))
                                        .map(user -> userRepository.getById(user.getId()))
                                        .map(ApiResponse::apiResponseOk),
                                ApiResponse.class))
                .andRoute(GET("/flux/user/get"), serverRequest ->
                        ok().body(just(serverRequest.queryParam("id").get())
                                        .map(s -> userRepository.getById(Long.valueOf(s)))
                                        .map(ApiResponse::apiResponseOk),
                                ApiResponse.class));
    }


}
