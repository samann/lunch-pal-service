package com.droidwolf.lunchpal.service.dao;

public interface GetUpdateDeleteDao<K, V> extends GetDao<K,V>, UpdateDao<K, V>, DeleteDao<K,V> {
}
