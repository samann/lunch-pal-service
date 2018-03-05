package com.droidwolf.lunchpal.service.dao.impl;

import com.droidwolf.lunchpal.service.dao.AbstractGetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.LunchSpot;
import com.hazelcast.core.IMap;

import java.util.UUID;

public class LunchSpotGetUpdateDeleteDao extends AbstractGetUpdateDeleteDao<UUID, LunchSpot> {
    public LunchSpotGetUpdateDeleteDao(IMap<UUID, LunchSpot> map) {
        super(map);
    }
}
