package com.droidwolf.lunchpal.service.domain;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(User copy) {
        this.name = copy.name;
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
