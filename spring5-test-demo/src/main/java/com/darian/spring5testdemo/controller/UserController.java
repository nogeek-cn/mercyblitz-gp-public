package com.darian.spring5testdemo.controller;

import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.UserRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 用户的
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    public final UserRemoteService userRemoteService;

    @GetMapping("findAll")
    public List<User> findAll() {
        return userRemoteService.findAll();
    }
}
