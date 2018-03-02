package com.droidwolf.lunchpal.service.dao;

import com.droidwolf.lunchpal.service.domain.User;
import com.hazelcast.core.IMap;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDao extends AbstractGetUpdateDeleteDao<UUID, User> {
    public UserDao(IMap<UUID, User> map) {
        super(map);
    }
}
