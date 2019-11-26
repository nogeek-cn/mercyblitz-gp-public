package com.darian.spring5webFluxdemo.web.controller;

import com.darian.spring5webFluxdemo.domain.User;
import com.darian.spring5webFluxdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Tolerate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final UserRepository userRepository;

    @GetMapping("")
    public Mono<String> index(
            @RequestParam(required = false) String message) {
        return Mono.just(message);
    }

    @PostMapping("/user/save")
    public Mono<User> saveUser(User user) {
        if (userRepository.saveUser(user)) {
            return Mono.just(user);
        }
        return Mono.empty();
    }

    @GetMapping("/user/list")
    public Collection<User> users() {
        return userRepository.findAll();
    }

    @GetMapping("/user/flux")
    public Flux<User> usersList() {
        Flux<User> userFlux = Flux.fromIterable(userRepository.findAll());
        return userFlux;
    }

}
