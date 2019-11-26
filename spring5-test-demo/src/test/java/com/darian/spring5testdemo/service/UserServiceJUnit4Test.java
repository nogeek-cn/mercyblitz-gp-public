package com.darian.spring5testdemo.service;


import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.impl.UserServiceInMemoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = UserServiceInMemoryImpl.class)
public class UserServiceJUnit4Test {

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