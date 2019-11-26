package com.darian.spring5webFluxdemo.repository;

import com.darian.spring5webFluxdemo.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Map<Long, User> repository = new ConcurrentHashMap<>();

    public boolean saveUser(User user) {
        return repository.put(user.getId(), user) == null;
    }

    public List<User> findAll() {
        return repository.values().stream().collect(Collectors.toList());
    }

    public User getById(Long id) {
        return repository.get(id);
    }

    public User update(User user) {
        repository.putIfAbsent(user.getId(), user);
        return user;
    }

    public Flux<User> allUserFlux() {
        return Flux.fromIterable(findAll());
    }
}
