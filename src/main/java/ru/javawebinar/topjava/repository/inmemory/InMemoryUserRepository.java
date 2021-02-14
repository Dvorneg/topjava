package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.web.user.AbstractUserController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*@Repository - по аналогии с меал, там нет этого, по заданию, но надо поставить.... */
@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private final Map<Integer, User> repository = new ConcurrentHashMap<>(); //Добавляем для хранения
    private final AtomicInteger counter = new AtomicInteger(0); //add  counter

    @Override
    public boolean delete(int id) {
        repository.remove(id);
        log.info("delete {}", id);
        return true;
    }

    @Override
    public User save(User user) {
        repository.put(counter.getAndIncrement(), user);
        log.info("save {}", user);
        return user;
    }

    @Override
    public User get(int id) {
        User user = repository.get(id);
        log.info("get {}", id);
        return user;
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        return new ArrayList<User>( repository.values());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        //return UserService.getByEmail(email);
        // TODO: передалать на stream 14.02.2021
        //проййтись надо по колллекции , и вернуть только то, где е-майл, нужный  нам.
        for (User user : repository.values()) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }
}
