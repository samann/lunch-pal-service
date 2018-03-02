package com.droidwolf.lunchpal.service.dao;

public interface UpdateDao<K, V> {
    void save(K key, V value);
}
