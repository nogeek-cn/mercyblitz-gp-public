package com.darian.service.impl;

import com.darian.domain.User;
import com.darian.service.UserService;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/***
 *
 *
 * @author <a href="mailto:1934849492@qq.com">Darian</a> 
 * @date 2020/5/30  18:27
 */
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(getClass().getName());

    private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Override
    public boolean addUser(User user) {
        logger.info("user: " + user);
        return true;
    }

}
