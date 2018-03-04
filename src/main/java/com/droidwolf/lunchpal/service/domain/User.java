package com.droidwolf.lunchpal.service.domain;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private final UUID id;
    private UUID groupId;
    private String groupDesc;
    private String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.groupId = UUID.randomUUID();
        this.name = name;
    }

    public User(User copy) {
        this.id = copy.id;
        this.groupId = copy.groupId;
        this.name = copy.name;
        this.groupDesc = copy.groupDesc;
    }

    public UUID getId() {
        return id;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
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
