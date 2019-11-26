package com.darian.spring5testdemo.service.impl;

import com.darian.spring5testdemo.domain.User;
import com.darian.spring5testdemo.service.UserService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserServiceInMemoryImpl implements UserService {

    private Map<Long, User> map = new ConcurrentHashMap<>();

    @Override
    public boolean save(User user) {
        return map.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return map.values().stream().collect(Collectors.toList());
    }
}
