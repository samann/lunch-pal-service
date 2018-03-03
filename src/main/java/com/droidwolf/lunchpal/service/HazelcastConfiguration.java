package com.droidwolf.lunchpal.service;

import com.droidwolf.lunchpal.service.dao.GetUpdateDeleteDao;
import com.droidwolf.lunchpal.service.dao.UserDao;
import com.droidwolf.lunchpal.service.domain.User;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class HazelcastConfiguration {

    private final String userMapName = "userMapName";

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
    public GetUpdateDeleteDao<UUID, User> userDao(HazelcastInstance hazelcastInstance) {
        return new UserDao(hazelcastInstance.getMap(userMapName));
    }

}
