package com.darian.spring5testdemo.controller;

import com.darian.spring5testdemo.Spring5TestDemoApplicationTests;
import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.UserRemoteService;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/***
 * {@link UserController}
 */
@SpringJUnitConfig(classes = {UserController.class, Spring5TestDemoApplicationTests.MockConfiguration.class})
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void testFindAll() {
        // 这个返回结果 UserController#findAll() -> UserRemoteService#findAll();
        // 实际调用时 Mock UserRemoteService Bean
        List<User> all = userController.findAll();
        Assert.assertEquals(2, all.size());
        Assert.assertEquals("darian", all.get(0).getName());
    }


}