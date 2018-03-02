package com.droidwolf.lunchpal.service.dao;

import java.util.List;

public interface GetDao<K, V> {
    V get(K key);
    List<V> getAll();
}
