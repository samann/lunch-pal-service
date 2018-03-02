package com.droidwolf.lunchpal.service.dao;

import com.hazelcast.core.IMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractGetUpdateDeleteDao<K, V> implements GetDao<K, V>, UpdateDao<K, V>, DeleteDao<K, V> {

    private final IMap<K, V> map;

    private final long leaseTime = 100;

    private final long waitTime = 100;

    public AbstractGetUpdateDeleteDao(IMap<K, V> map) {
        this.map = map;
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }
    @Override
    public void lock(K key) {
        try {
             map.tryLock(key, leaseTime, TimeUnit.MILLISECONDS, waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Got interrupted: " + e.getMessage());
        }
    }

    @Override
    public void unlock(K key) {
        map.unlock(key);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public List<V> getAll(){
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(K key, V value) {
        map.set(key, value);
    }
}
