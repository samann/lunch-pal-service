package com.droidwolf.lunchpal.service.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class LunchSpotDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    private String name;
    private String description;
    private UUID groupId;

    public LunchSpotDto() {
    }

    public LunchSpotDto(String name, String description, UUID groupId) {
        this.name = name;
        this.description = description;
        this.groupId = groupId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
