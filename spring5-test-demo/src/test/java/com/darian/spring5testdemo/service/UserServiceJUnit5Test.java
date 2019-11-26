package com.darian.spring5testdemo.service;

import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.impl.UserServiceInMemoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

@SpringJUnitConfig(classes = UserServiceInMemoryImpl.class)
public class UserServiceJUnit5Test {

    @Autowired
    private UserService userService;

    @Test
    public void add() {
        User user = new User(1L, "darian");
        assertTrue(userService.save(user));
        assertFalse(userService.save(user));
//        assertTrue(userServiceInMemoryImpl.save(user));
    }
}