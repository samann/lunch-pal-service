package com.droidwolf.lunchpal.service.dao;

import com.hazelcast.core.IMap;

import java.util.ArrayList;
import java.util.List;

public class AbstractGetDao<K, V> implements GetDao<K,V> {

    private final IMap<K, V> map;

    public AbstractGetDao(IMap<K, V> map) {
        this.map = map;
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public List<V> getAll() {
        return new ArrayList<>(map.values());
    }
}
