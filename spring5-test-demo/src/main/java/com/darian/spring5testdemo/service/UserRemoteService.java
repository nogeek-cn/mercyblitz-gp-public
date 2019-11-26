package com.darian.spring5testdemo.service;

import com.darian.spring5testdemo.domain.User;

import java.util.List;

/***
 * 远程服务
 */
public interface UserRemoteService {

    List<User> findAll();
}
