package com.droidwolf.lunchpal.service.domain;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final UUID id;

    private String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public User(User copy) {
        this.id = copy.id;
        this.name = copy.name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + '}';
    }
}
