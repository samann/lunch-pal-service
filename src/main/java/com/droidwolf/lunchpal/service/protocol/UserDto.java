package com.droidwolf.lunchpal.service.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    private String name;
    private String groupDesc;
    private UUID groupId;

    public UserDto() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
