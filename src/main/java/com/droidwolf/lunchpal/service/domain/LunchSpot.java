package com.droidwolf.lunchpal.service.domain;

public class LunchSpot {
    private String name;
    private String description;
    private Rating rating;

    public LunchSpot(String description, String name) {
        this.description = description;
        this.name = name;
        this.rating = new Rating();
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
}
