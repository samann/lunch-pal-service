package com.droidwolf.lunchpal.service.dao;

public interface DeleteDao<K, V> {
    V remove(K key);
    void lock(K key);
    void unlock(K key);
}
