package com.darian.bootstrap;

import com.darian.domain.User;
import com.darian.service.UserService;
import com.darian.service.impl.UserServiceImpl;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  18:33
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setName("xx");

        UserService userService = new UserServiceImpl();
        userService.addUser(user);
    }
}
