package com.droidwolf.lunchpal.service;

import com.droidwolf.lunchpal.service.dao.GetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.dao.impl.LunchSpotGetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.dao.impl.UserGetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.domain.LunchSpot;
import com.droidwolf.lunchpal.service.domain.User;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class HazelcastConfiguration {

    private final String userMapName = "userMapName";
    private final String lunchSpotMapName = "lunchSpotMap";

    @Bean
    public HazelcastInstance hazelcastInstance() {
        MapConfig userMapConfig = new MapConfig(userMapName);
        Map<String, MapConfig> mapConfigs = new HashMap<>();
        mapConfigs.put(userMapName, userMapConfig);

        Config config = new Config();
        config.setMapConfigs(mapConfigs);
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public GetUpdateDeleteDao<UUID, User> userGetUpdateDeleteDao(HazelcastInstance hazelcastInstance) {
        return new UserGetUpdateDeleteDao(hazelcastInstance.getMap(userMapName));
    }

    @Bean
    public GetUpdateDeleteDao<UUID, LunchSpot> lunchSpotGetUpdateDeleteDao(HazelcastInstance hazelcastInstance) {
        return new LunchSpotGetUpdateDeleteDao(hazelcastInstance.getMap(lunchSpotMapName));
    }

}
