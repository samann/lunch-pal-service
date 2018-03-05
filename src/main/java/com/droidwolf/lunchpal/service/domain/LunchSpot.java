package com.droidwolf.lunchpal.service.domain;

import com.droidwolf.lunchpal.service.protocol.LunchSpotDto;

import java.io.Serializable;
import java.util.UUID;

public class LunchSpot implements Serializable {
    private final UUID id;
    private String name;
    private String description;
    private Rating rating;
    private UUID groupId;

    public LunchSpot(LunchSpotDto lunchSpotDto) {
        this.id = UUID.randomUUID();
        this.description = lunchSpotDto.getDescription();
        this.name = lunchSpotDto.getName();
        this.groupId = lunchSpotDto.getGroupId();
        this.rating = new Rating();
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
