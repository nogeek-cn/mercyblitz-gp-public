package com.darian.spring5testdemo.service;

import com.darian.spring5testdemo.domain.User;

import java.util.List;

/***
 * 用户服务 （RPC）
 */
public interface UserService {

    boolean save(User user);

    List<User> findAll();
}
