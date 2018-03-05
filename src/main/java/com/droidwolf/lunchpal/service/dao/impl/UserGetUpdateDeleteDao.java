package com.droidwolf.lunchpal.service.dao.impl;

import com.droidwolf.lunchpal.service.dao.AbstractGetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.User;
import com.hazelcast.core.IMap;

import java.util.UUID;

public class UserGetUpdateDeleteDao extends AbstractGetUpdateDeleteDao<UUID, User> {
    public UserGetUpdateDeleteDao(IMap<UUID, User> map) {
        super(map);
    }
}
